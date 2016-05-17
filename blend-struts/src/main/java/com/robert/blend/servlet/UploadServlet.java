package com.robert.blend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name = "upload", urlPatterns = { "/upload" })
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		System.out.println("上传文件的Servlet初始化完成！");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		System.out.println(name);
		// 获取文件上传域
		Part part = request.getPart("file");
		out.println("上传文件的类型：" + part.getContentType());
		out.println("上传文件的大小：" + part.getSize());
		// 提取上传文件的原始名
		String fileNameInfo = part.getHeader("content-disposition");
		String fileName = fileNameInfo.substring(
				fileNameInfo.indexOf("filename=\"") + 10,
				fileNameInfo.length() - 1);
		out.println("上传文件的名称：" + fileName);
		// 将上传文件写入服务器
		part.write(getServletContext().getRealPath("/uploadFiles") + "/"
				+ fileName);
	}

}
