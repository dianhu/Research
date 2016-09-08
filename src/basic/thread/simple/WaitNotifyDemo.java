package basic.thread.simple;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *1）使用wait()、notify()和notifyAll()时需要先对调用对象加锁。
 *2）调用wait()方法后，线程状态由RUNNING变为WAIT-ING，并将当前线程放置到对象的等待队列。
 *3）notify()或notifyAll()方法调用后，等待线程依旧不会从wait()返回，需要调用notify()或notifAll()的线程释放锁之后，等待线程才有机会从wait()返回。
 *4）notify()方法将等待队列中的一个等待线程从等待队列中移到同步队列中，而notifyAll()方法则是将等待队列中所有的线程全部移到同步队列，被移动的线程状态由WAITING变为BLOCKED。
 *5）从wait()方法返回的前提是获得了调用对象的锁。
 *
 * @author H.C.Y
 * @date 2016年9月8日 下午12:48:03 
 */
public class WaitNotifyDemo{
	static boolean flag = true;
	static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread notifyThread = new Thread(new Notify(), "NotifyThread");
		notifyThread.start();
	}
	
	static class Wait implements Runnable{
		public void run(){
			// 加锁，拥有lock的Monitor
			synchronized (lock) {
				while(flag){
					try{
						System.out.println(Thread.currentThread()+"flag is true.wait @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();//在lock对象上等待，并释放了lock对象的monitor,进入wait队列
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread()+"flag is false. running @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}
	
	static class Notify implements Runnable{
		public void run(){
			synchronized (lock) {
				System.out.println(Thread.currentThread()+"hold lock. notify @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();//通知lock对象上wait的线程，此时wait线程从wait队列进入阻塞队列，当lock对象的monitor被释放的时候，才重新获得monitor，从wait方法返回，继续执行下面的代码
				flag = false;
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized (lock) {
				System.out.println(Thread.currentThread()+"hold lock again. sleep @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}