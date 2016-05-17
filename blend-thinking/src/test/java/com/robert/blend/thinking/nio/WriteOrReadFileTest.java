package com.robert.blend.thinking.nio;

import org.junit.Test;

public class WriteOrReadFileTest {

	@Test
	public void test() {
		new WriteOrReadFile().readFromFile(WriteOrReadFileTest.class.getClassLoader().getResource("test.txt").getFile());
	}

}
