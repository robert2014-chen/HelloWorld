package mybatis;

public class MyThread {

	public static void main(String[] args) {
		new Thread(){
			public void run() {
				System.out.println("hello");
			};
		}.start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hi");
			}
		}).start();
	}
}
