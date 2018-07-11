package dh01.research.basic.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public  final class ThreadPoolTest {
	String [] taskResults = {"a","b","c","d","e","f","g","h"};
	private void mutiPrint(){
		ExecutorService executor = Executors.newFixedThreadPool(7, new NamedThreadFactory("Test"));
		List<Future<String>> tasksResult = new ArrayList<Future<String>>();
		for(int i=0;i<taskResults.length;i++){
			tasksResult.add(executor.submit(new Task(taskResults[i])));
		}
		executor.shutdown();
		for (Future<String>  future:tasksResult) {
			String r=null;
			try {
				r=future.get(500l, TimeUnit.MILLISECONDS);
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("取得线程执行的返回结果："+r);
			}
	}
	public static void main(String[] args) {
		new ThreadPoolTest().mutiPrint();
	}
	class Task implements Callable<String> {
		private String taskResults;
		public Task(String taskResults){
			this.taskResults = taskResults;
		}
		public String call() throws Exception {
			System.out.println("消息:我被线程池的一个线程>"+Thread.currentThread().getName()+"执行了,返回结果："+taskResults);
			return taskResults;
		}
	}
}
