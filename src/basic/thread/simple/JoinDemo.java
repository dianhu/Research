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
		Thread t2 = new Thread(new Mytask(t1));//等t1执行完了再执行t2
		t1.start();
		t2.start();
		t1.join();// t1线程join到main线程中，main线程进入wait状态，等t1线程执行完毕，main线程才被唤醒继续执行接下来的代码。
		System.out.println("main thread say hello!");

	}

	static class Mytask implements Runnable {
		private Thread dependThread;

		public Mytask(Thread depend) {
			this.dependThread = depend;
		}

		public void run() {
			System.out.println("Second task started");
			try {
				this.dependThread.join();//等dependThread执行完了，再唤醒当前线程执行下面的语句。
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Second task sleeping for 1 seconds");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Second task completed");
		}
	}
}
