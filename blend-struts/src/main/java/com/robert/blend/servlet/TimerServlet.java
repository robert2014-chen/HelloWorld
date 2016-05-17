package com.robert.blend.servlet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.swing.Timer;

@WebServlet(name = "timerServlet", urlPatterns = { "/timerServlet" }, loadOnStartup = 1)
public class TimerServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TimerServlet init!");
		super.init(config);
		Timer t = new Timer(1000*1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("init " + new Date());
			}
		});
		t.start();
	}

}
