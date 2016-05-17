package com.robert.blend.web.tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IteratorTag extends SimpleTagSupport {

	private String collection;

	private String item;

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Collection itemList = (Collection) getJspContext().getAttribute(
				collection);
		for (Object o : itemList) {
			// 将集合中的元素设置到页面
			getJspContext().setAttribute(item, o);
			// 输出标签体
			getJspBody().invoke(null);
		}
		super.doTag();
	}
}
