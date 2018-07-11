package dh01.research.basic.thread;

import java.util.concurrent.TimeUnit;

public class Shutdown {
	public static void main(String[] args) throws InterruptedException {
		Runner one = new Runner();
		Thread countThread = new Thread(one,"CountThread");
		countThread.start();
		//睡眠1秒，main线程对countThread进行中断，使countThread能够感知中断而结束
		TimeUnit.SECONDS.sleep(3);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two,"CountThread");
		countThread.start();
		TimeUnit.SECONDS.sleep(3);
		two.cancel();
		
	}
	private static class Runner implements Runnable{
		private long i;
		private volatile boolean on  = true;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(on&&Thread.currentThread().isInterrupted()){
				i++;
			}
			System.out.println("Count i = "+i);
		}
		public void cancel(){
			on = false;
		}
	}
}
