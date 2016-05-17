package com.robert.blend.web.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket/chat")
public class ChatEndpoint {

	private static final String GUEST_PREFIX = "访客";

	private static final AtomicInteger connectionIds = new AtomicInteger(0);

	private static final Set<ChatEndpoint> clientSet = new CopyOnWriteArraySet<ChatEndpoint>();

	private final String nickname;

	private Session session;

	public ChatEndpoint() {
		this.nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
	}

	@OnOpen
	public void start(Session session) {
		this.session = session;
		clientSet.add(this);
		String message = String.format("【%s %s】", nickname, "加入了聊天室");
		broadcast(message);
	}

	@OnClose
	public void end() {
		clientSet.remove(this);
		String message = String.format("【%s %s】", nickname, "离开了聊天室");
		broadcast(message);
	}

	@OnMessage
	public void incoming(String message) {
		String filteredMessage = String.format("%s:%s", nickname,
				filter(message));
		broadcast(filteredMessage);
	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		System.out.println("WebSock服务端错误" + t);
	}

	private static void broadcast(String msg) {
		for (ChatEndpoint client : clientSet) {
			try {
				synchronized (client) {
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (Exception e) {
				System.out.println("聊天错误，向客户端" + client + "发送消息出现错误！");
				clientSet.remove(client);
				try {
					client.session.close();
				} catch (IOException e1) {
				}
				String message = String.format("【%s %s】", client.nickname,
						"已经被断开了连接");
				broadcast(message);
			}
		}
	}

	private static String filter(String msg) {
		if (null == msg) {
			return null;
		}

		char content[] = new char[msg.length()];
		msg.getChars(0, msg.length(), content, 0);
		StringBuilder result = new StringBuilder(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
			}
		}

		return result.toString();
	}
}
