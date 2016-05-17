package com.robert.blend.thinking.innerclass;

import org.junit.Test;

import com.robert.blend.thinking.innerclass.MyInnerClass;

public class MyInnerClassTest {

	@Test
	public void test() {
		new MyInnerClass.Hello3().print();

		(new MyInnerClass()).new Hello().print();

		new MyInnerClass().outerPrint();

		new MyInnerClass().threadPrint();
	}

}
