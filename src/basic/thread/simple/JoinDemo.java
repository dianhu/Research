package basic.thread.simple;

import java.util.concurrent.TimeUnit;

public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("First task started");
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println("First task sleeping for 3 seconds");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("First task completed");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Second task started");
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Second task sleeping for 1 seconds");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Second task completed");
			}
		});
		t1.start();
		t2.start();
		t1.join();//t1线程join到main线程中，main线程进入wait状态，等t1线程执行完毕，才被唤醒继续执行接下来的代码。
		System.out.println("main thread say hello!");
		
	}
}
