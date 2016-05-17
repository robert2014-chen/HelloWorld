package com.robert.blend.thinking.innerclass;

/**
 * <p>
 * 像一个属性样定义在外部类中，可以使用外部类所有的成员
 * </p>
 * <p>
 * <table>
 * <tr>
 * <td></td>
 * <td>代码</td>
 * <td>注意事项</td>
 * </tr>
 * <tr>
 * <td>静态内部类</td>
 * <td><code>public static String pro3 = "pro3";
 * static class Hello3 {
 * public void print() {
 * System.out.println(pro3);
 * }
 * }</code></td>
 * <td>
 * <ol>
 * <li>不能定义在方法体内</li>
 * <li>只能访问外部类的静态成员</li>
 * </ol>
 * </td>
 * </tr>
 * </table>
 * </p>
 * 
 * @author CHEN
 *
 */
public class MyInnerClass {

	public String pro1 = "pro1";

	/**
	 * <p>
	 * 全局非静态内部类，在外部使用此类的格式：(new outterClass()).new innerClass()
	 * </p>
	 * 
	 * @author CHEN
	 *
	 */
	class Hello {
		public void print() {
			System.out.println(pro1);
		}
	}

	public String pro2 = "pro2";

	public void outerPrint() {

		final int j = 0;

		/**
		 * <p>
		 * 局部内部类，可访问外部的所有成员，但访问方法体的成员必须是被final修饰
		 * </p>
		 * 
		 * @author CHEN
		 *
		 */
		class Hello2 {
			public void innerPrint() {
				System.out.println(pro2);
				System.out.println("j value is " + j);
			}
		}
		new Hello2().innerPrint();

	}

	public static String pro3 = "pro3";

	static class Hello3 {
		public void print() {
			System.out.println(pro3);
		}
	}

	public String pro4 = "pro4";

	public void threadPrint() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(pro4);
			}
		}).start();
	}
}
