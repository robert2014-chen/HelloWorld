package com.robert.blend.listener;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyAsyncListener
 * 此监听器需要手动添加，否则无效
 */
@WebListener
public class MyAsyncListener implements AsyncListener {

	/**
	 * Default constructor.
	 */
	public MyAsyncListener() {
	}

	/**
	 * @see AsyncListener#onComplete(AsyncEvent)
	 */
	public void onComplete(AsyncEvent arg0) throws java.io.IOException {
		// 当异步调用完成时触发该方法
		System.out.println("success");
	}

	/**
	 * @see AsyncListener#onError(AsyncEvent)
	 */
	public void onError(AsyncEvent event) throws java.io.IOException {
		// 当异步调用出错时触发该方法
		event.getThrowable().printStackTrace();
		System.out.println(event.getAsyncContext().getRequest().getRemoteHost()
				+ "异步调用出错！");
	}

	/**
	 * @see AsyncListener#onStartAsync(AsyncEvent)
	 */
	public void onStartAsync(AsyncEvent arg0) throws java.io.IOException {
		// 当异步调用开始时触发该方法
	}

	/**
	 * @see AsyncListener#onTimeout(AsyncEvent)
	 */
	public void onTimeout(AsyncEvent event) throws java.io.IOException {
		// 当异步调用超时时触发该方法
		System.out.println(event.getAsyncContext().getRequest().getRemoteHost()
				+ "异步调用超时！");
	}

}
