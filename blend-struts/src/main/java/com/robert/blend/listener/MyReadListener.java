package com.robert.blend.listener;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebListener;

public class MyReadListener implements ReadListener {

	private ServletInputStream input;

	private AsyncContext context;

	public MyReadListener(ServletInputStream input, AsyncContext context) {
		this.input = input;
		this.context = context;
	}

	@Override
	public void onAllDataRead() throws IOException {
		// 所有数据读取完成时激发该方法
		System.out.println("读取数据完成！");
	}

	@Override
	public void onDataAvailable() throws IOException {
		// 所有数据可用时激发该方法
		System.out.println("数据可用！");
		try {
			Thread.sleep(50 * 1000);
			StringBuffer stb = new StringBuffer();
			int len = -1;
			byte[] buff = new byte[1024];
			// 采用原始方法读取浏览器向Servlet提交的数据
			while (input.isReady() && (len = input.read(buff)) > 0) {
				String data = new String(buff, 0, len);
				stb.append(data);
			}
			System.out.println(stb.toString());
			context.getRequest().setAttribute("info", stb.toString());
			context.dispatch("/async/async.jsp");
		} catch (Exception e) {
		}
	}

	@Override
	public void onError(Throwable t) {
		// 读取数据出现错误时激发该方法
		t.printStackTrace();
	}

}