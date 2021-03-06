package com.robert.blend.thinking.jvm.test;

/**
 * <p>
 * 原理详见JEE_note.docx中的JVM
 * </p>
 * 
 * @author CHEN
 *
 */
public class StaticTest {
	public static void main(String[] args) {
		// staticFunction();
		new StaticTest();
	}

	// static StaticTest st = new StaticTest();
	static {
		System.out.println("1");
	}
	//非静态代码块
	{
		System.out.println("2");
	}

	StaticTest() {
		System.out.println("3");
		System.out.println("a=" + a + ",b=" + b);
	}

	public static void staticFunction() {
		System.out.println("4");
	}

	int a = 110;
	static int b = 112;
}
