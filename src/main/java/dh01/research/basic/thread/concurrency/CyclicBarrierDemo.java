package dh01.research.basic.thread.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Time : 20-2-11 下午11:03
 * Author : hcy
 * Description :
 *  * A synchronization aid that allows a set of threads to all wait for
 * each other to reach a common barrier point.  CyclicBarriers are
 * useful in programs involving a fixed sized party of threads that
 * must occasionally wait for each other. The barrier is called
 * <em>cyclic</em> because it can be re-used after the waiting threads
 * are released.
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all task finished! " + System.currentTimeMillis());
            }
        });

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);//do something
                System.out.println("t1 finished.");
                cyclicBarrier.await();
                System.out.println("t1 get t2 finished. " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);//do something
                System.out.println("t2 finished.");
                cyclicBarrier.await();
                System.out.println("t2 get t1 finished. " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(20);
        System.out.println("================");
        cyclicBarrier.reset();//reset 重复利用

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);//do something
                System.out.println("t3 finished.");
                cyclicBarrier.await();
                System.out.println("t3 get t4 finished. " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);//do something
                System.out.println("t4 finished.");
                cyclicBarrier.await();
                System.out.println("t4 get t3 finished. " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
