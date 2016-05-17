package com.robert.blend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.robert.blend.listener.MyAsyncListener;

/**
 * Servlet implementation class AsyncServlet
 */
@WebServlet(urlPatterns = { "/async" }, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AsyncServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html);charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<title>异步调用示例</title>");
		out.println("进入Servlet的时间" + new java.util.Date() + "</br>");
		// 创建AsyncContext，开始异步调用
		AsyncContext actx = request.startAsync();
		// 设置异步调用的超时时长
		actx.setTimeout(60 * 1000);
		// 启动异步调用的线程
		actx.start(new HelloAsync(actx));
		actx.addListener(new MyAsyncListener());

		out.println("结束Servlet的时间" + new java.util.Date() + "</br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

class HelloAsync implements Runnable {

	private AsyncContext actx;

	public HelloAsync(AsyncContext actx) {
		this.actx = actx;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(50 * 1000);
			ServletRequest req = actx.getRequest();
			List<String> books = new ArrayList<String>();
			books.add("Java讲义");
			books.add("Thinking in Java");
			req.setAttribute("books", books);
			actx.dispatch("/async/async.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
