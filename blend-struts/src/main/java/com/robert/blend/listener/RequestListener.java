package com.robert.blend.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestAttributeListener,
		ServletRequestListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequestListener#requestDestroyed(javax.servlet.
	 * ServletRequestEvent)
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		// 用户请求到达，被初始化时触发此方法

		System.out
				.println("发向 "
						+ ((HttpServletRequest) servletRequestEvent
								.getServletRequest()).getRequestURI()
						+ "的请求被销毁！");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletRequestListener#requestInitialized(javax.servlet
	 * .ServletRequestEvent)
	 */
	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		// 用户的请求结束，被销毁时触发此方法
		System.out
				.println("发向"
						+ ((HttpServletRequest) servletRequestEvent
								.getServletRequest()).getRequestURI()
						+ "的请求被初始化！");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletRequestAttributeListener#attributeAdded(javax.servlet
	 * .ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeAdded(
			ServletRequestAttributeEvent servletRequestAttributeEvent) {
		// 添加属性
		System.out.println("添加到请求的键值：" + servletRequestAttributeEvent.getName()
				+ " - " + servletRequestAttributeEvent.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletRequestAttributeListener#attributeRemoved(javax.
	 * servlet.ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeRemoved(
			ServletRequestAttributeEvent servletRequestAttributeEvent) {
		// 移除属性
		System.out.println("从请求中移除的键值："
				+ servletRequestAttributeEvent.getName() + " - "
				+ servletRequestAttributeEvent.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletRequestAttributeListener#attributeReplaced(javax
	 * .servlet.ServletRequestAttributeEvent)
	 */
	@Override
	public void attributeReplaced(
			ServletRequestAttributeEvent servletRequestAttributeEvent) {
		// 替换属性值
		System.out.println("将请求中键为" + servletRequestAttributeEvent.getName()
				+ "值替换为" + servletRequestAttributeEvent.getValue());
	}

}
