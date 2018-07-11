package dh01.research.basic.thread.simple;

import java.util.concurrent.Executor;

public class ExecutorDemo {
	
	class PrintThreadId implements Runnable {
		@Override
		public void run() {
			System.out.println("线程ID:"+Thread.currentThread().getId());
		}
	}

	static class WithinThreadExecutor implements Executor {
		@Override
		public void execute(Runnable r) {
			r.run();
			
		}
	}

	class ThreadPerTaskExecutor implements Executor {
		@Override
		public void execute(Runnable r) {
			new Thread(r).start();
		}
	}
	public static void main(String[] args) {
		
		System.out.println("主线程ID:"+Thread.currentThread().getId());
		
		ExecutorDemo demo = new ExecutorDemo();
		//成员内部类的调用方法 new outerClass().new innerClass() 
		PrintThreadId task = demo.new PrintThreadId(); // 新建一个任务
		//在静态方法中，静态内部类可以直接调
		Executor exec = new WithinThreadExecutor(); // 使用当前线程的策略
		exec.execute(task);

		Executor muliExec = demo.new ThreadPerTaskExecutor(); // 使用多线程策略
		muliExec.execute(task);
	}

}
