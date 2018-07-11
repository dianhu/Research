package dh01.research.basic.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

/**
 * Time : 18-7-10 下午1:39
 * Author : hcy
 * Description : Synchronized依靠对象
 * jstack pid
 */
public class SyncMonitor {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public synchronized void method1() {
        sleepMinutes(10);
    }

    public synchronized void method2() {
        sleepMinutes(10);
    }

    public void method3() {
        synchronized (this) {
            sleepMinutes(10);
        }
    }

    public static synchronized void method4() {
        sleepMinutes(10);
    }

    public void method5() {
        synchronized (SyncMonitor.class) {
            sleepMinutes(10);
        }
    }

    public void method6() {
        synchronized (lock1) {
            sleepMinutes(10);
        }
    }

    public void method7() {
        synchronized (lock1) {
            sleepMinutes(10);
        }
    }

    public void method8() {
        synchronized (lock2) {
            sleepMinutes(10);
        }
    }

    public void method9() {
        synchronized (lock2) {
            sleepMinutes(10);
        }
    }


    public static void main(String[] args) {
        getProcessID();
        SyncMonitor syncMonitor = new SyncMonitor();
        new Thread(syncMonitor::method1, "this-t1").start();
        new Thread(syncMonitor::method2, "this-t2").start();
        new Thread(syncMonitor::method3, "this-t3").start();
        new Thread(() -> method4(), "class-t1").start();
        new Thread(syncMonitor::method5, "class-t2").start();
        new Thread(syncMonitor::method6, "lock1-t1").start();
        new Thread(syncMonitor::method7, "lock1-t2").start();
        new Thread(syncMonitor::method8, "lock2-t1").start();
        new Thread(syncMonitor::method9, "lock2-t2").start();
    }

    private static final int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])
                .intValue();
    }

    private static void sleepMinutes(int minute) {
        try {
            TimeUnit.MINUTES.sleep(minute);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
