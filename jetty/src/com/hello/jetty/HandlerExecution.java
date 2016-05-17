package com.hello.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.hello.servlet.HelloServlet;

public class HandlerExecution {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8081);

		ServletContextHandler servletContextHandler = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		// 相当于工程目录，设置上下文
		servletContextHandler.setContextPath("/");
		server.setHandler(servletContextHandler);

		servletContextHandler.addServlet(new ServletHolder(new HelloServlet()), "/hello");
		// HandlerCollection hc = new HandlerCollection();
		// hc.setHandlers(new Handler[] { new HelloHandler() });
		// server.setHandler(hc);
		server.start();
		server.join();
	}
}
