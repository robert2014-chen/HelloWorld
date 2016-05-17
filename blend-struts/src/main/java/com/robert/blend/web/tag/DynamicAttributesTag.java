package com.robert.blend.web.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DynamicAttributesTag extends SimpleTagSupport implements
		DynamicAttributes {
	// 保存每个属性名的集合
	private List<String> keys = new ArrayList<String>();
	// 保存每个属性值的集合
	private List<Object> values = new ArrayList<Object>();

	@Override
	public void setDynamicAttribute(String uri, String localname, Object value)
			throws JspException {
		keys.add(localname);
		values.add(value);
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<ol>");
		for (int i = 0; i < keys.size(); i++) {
			out.println("<li>" + keys.get(i) + "=" + values.get(i) + "</li>");
		}
		out.println("</ol>");
	}

}
