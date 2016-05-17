import java.sql.Date;
import java.util.Calendar;

import sun.misc.Cleaner;

public class BaseTypeMutileThreadTest {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1);
						A.t = !A.t;
						System.out.println("Change Value"
								+ Calendar.getInstance().getTimeInMillis());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}) {
			}.start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("invoke B!!    "
							+ Calendar.getInstance().getTimeInMillis() + "    "
							+ A.t);
				}
			}) {
			}.start();
		}
	}
}

class A {
	public static boolean t = true;
}