package basic.thread.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * callable的两种实现方式
 * @author H.C.Y
 * @date 2016年9月2日 下午5:44:24 
 */
public class CallableDemo {
	
	static class myCallable implements Callable<String>{
		private int id;
		public myCallable(int id){
			this.id = id;
		}
		public String call() throws Exception{
			System.out.println("call方法被调用！！！");
			return "call方法被调用，返回结果："+id+",调用的线程"+Thread.currentThread().getName();
		}
	}
	public static void main(String[] args) {
		//method1();
		method2();
	}
	/**
	 *　顺序的取回结果，如果后面的任务比前面的任务先执行完毕，
	 *　也只能等到前面的取回了，再取后面的。
	 * @author H.C.Y
	 * @date 2016年9月2日 下午5:44:52 
	 */
	static void method1(){
		
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Future<String>> rstList  = new ArrayList<Future<String>>();
		//创建10个任务并执行  
		for(int i=0;i<10;i++){
			//使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中  
			Future<String> future = executor.submit(new myCallable(i));
			rstList.add(future);
		}
		//遍历任务结果
		for(Future<String> fs:rstList){
				try {
					System.out.println(fs.get());//打印各个线程（任务）执行的结果  
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					executor.shutdown();
				}
		}
		
	}
	/**
	 *　采用ExecutorCompletionService，任务执行完结果会放入到此类中的一个队列里面，取结果的时候
	 *　从此队列中取，取的顺序是哪个先执行完就取哪个。
	 * @author H.C.Y
	 * @date 2016年9月2日 下午5:49:06 
	 */
	static void method2(){
		
		ExecutorService executor = Executors.newCachedThreadPool();
		ExecutorCompletionService<String> compService = new ExecutorCompletionService(executor);
		//创建10个任务并执行  
		for(int i=0;i<10;i++){
			//使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中  
			compService.submit(new myCallable(i));
		}
		//遍历任务结果
		for(int i=0;i<10;i++){
				try {
					System.out.println(compService.take().get());//打印各个线程（任务）执行的结果  
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					executor.shutdown();
				}
		}
		
	}
}
