package dh01.research.basic.thread.simple;

/**
 * 两种线程实现的最基本方法
 * @author H.C.Y
 * @date 2016年9月2日 上午10:27:44 
 */
public class BasicDemo {
	public static void main(String[] args)  {
        System.out.println("主线程ID:"+Thread.currentThread().getId());
        //线程的实现方式
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.run();//直接调run方法，实际上还是当前线程调的
        //任务的实现方式
        MyRunnable runnable = new MyRunnable("task of thread3");
        Thread thread3 = new Thread(runnable);
        thread3.start();
    }
}
class MyThread extends Thread{
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }
}

class MyRunnable implements Runnable{
	private String name;
    public MyRunnable(String name) {
    	this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }
}
