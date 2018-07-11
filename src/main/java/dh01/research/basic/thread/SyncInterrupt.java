package dh01.research.basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * Time : 18-7-10 下午2:42
 * Author : hcy
 * Description : Sync中断无响应
 */
public class SyncInterrupt {
    public synchronized void method1() {
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncInterrupt syncInterrupt = new SyncInterrupt();
        Thread t1 = new Thread(syncInterrupt::method1, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        Thread t2 = new Thread(syncInterrupt::method2, "t2");
        t2.start();
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }

}
