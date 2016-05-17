package com.hello.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloHandler extends AbstractHandler {

	/**
	 * target:request的目标，可以是一个url或者一个适配器<br/>
	 * baseRequest:jetty可变的request对象，可以不封装<br/>
	 * request:不可变的request对象，可以被封装<br/>
	 * response:response对象，可以被封装<br/>
	 */
	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		/*************************************/
		System.out.println(target.toString());
		baseRequest.setHandled(true);// 表名这个请求已被处理过了
		/*************************************/
		request.getParameterMap();// 获取请求中的参数
		/*************************************/
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>Hello World</h1>");
		response.getWriter().println("<li>Request url: " + target + "</li>");
		response.getWriter().println(
				"<li>Server port: " + request.getServerPort() + "</li>");
	}
}