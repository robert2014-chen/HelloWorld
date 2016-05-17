package com.robert.blend.web.tag;

import java.util.ArrayList;
import java.util.List;

public class Test {
	static {
		t = new TestDemo("hello before",
				"assign the value before declaring variable, the value is ");// 静态变量在声明前的使用只能出现在赋值符号的左边
	}
	private static TestDemo t = new TestDemo("hello now",
			"assign the value when declaring variable, the value is ");
	static {
		t = new TestDemo("hello after",
				"assign the value fater declaring variable, the value is ");
	}
	public static void main(String[] args) {
		Test.t = new TestDemo("assigned by class", "**********");
		System.out.println("the final value is " + Test.t.getTestString());
	}
}
class TestDemo {
	private String testString;
	public String getTestString() {
		return testString;
	}
	public void setTestString(String testString) {
		this.testString = testString;
	}
	public TestDemo(String testString, String descString) {
		super();
		this.testString = testString;
		System.out.println(descString + this.testString);
	}
}
