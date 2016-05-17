package com.robert.blend.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FragmentTag extends SimpleTagSupport {

	private JspFragment fragment;

	public JspFragment getFragment() {
		return fragment;
	}

	public void setFragment(JspFragment fragment) {
		this.fragment = fragment;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<div style='padding:10px;border:1px solid #ade;border-radius:20px;'>");
		out.println("<h3>下面是动态传入的JSP片段</h3>");
		// 调用，输入”页面片段“
		fragment.invoke(null);
		out.println("</div>");
	}
}
