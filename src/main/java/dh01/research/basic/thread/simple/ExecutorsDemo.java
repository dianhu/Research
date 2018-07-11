package dh01.research.basic.thread.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		// ExecutorService executor = Executors.newFixedThreadPool(3);
		// ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {// 创建５个任务
			executor.execute(new Runnable() {// 匿名内部类
				public void run() {
					System.out.println(Thread.currentThread().getName() + "被调用了");
				}
			});
			System.out.println("**********第" + i + "次执行************");
		}
		executor.shutdown();
	}
}
