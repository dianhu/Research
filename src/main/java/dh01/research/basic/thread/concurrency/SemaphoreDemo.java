package dh01.research.basic.thread.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Time : 20-2-11 下午9:53
 * Author : hcy
 * Description :
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(2);
        IntStream.range(1, 3).forEach(i -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " in");
                try {
                    semaphore.acquire(2);
                    System.out.println(Thread.currentThread().getName() + " get the semaphore");
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //只释放1个令牌，然而需要2个，所以另外个线程一直阻塞
                    semaphore.release(1);
                    //semaphore.release(1000);  //release的许可和会当前许可相加，不受初始许可大小影响，所以用的时候要注意约定。
                    System.out.println(Thread.currentThread().getName() + " out");
                }
            }).start();
        });

        while (true) {
            System.out.println("AP->"+semaphore.availablePermits());
            System.out.println("QL->"+semaphore.getQueueLength());
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
}
