package com.robert.blend.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(filterName = "log", urlPatterns = { "*" }, dispatcherTypes = {
//		DispatcherType.ASYNC, DispatcherType.REQUEST, DispatcherType.ERROR,
//		DispatcherType.INCLUDE, DispatcherType.FORWARD }, asyncSupported = true)
//@MultipartConfig
public class LogFilter implements Filter {

	// 用于访问Filter的配置信息
	private FilterConfig config;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		this.config = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// 获取ServletContent对象
		ServletContext context = this.config.getServletContext();
		System.out.println(((HttpServletRequest) req).getServletPath() + " 访问");
		chain.doFilter(req, res);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
