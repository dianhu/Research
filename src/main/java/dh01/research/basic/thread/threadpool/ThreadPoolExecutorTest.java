package dh01.research.basic.thread.threadpool;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Time : 20-2-16 下午6:28
 * Author : hcy
 * Description :
 */
public class ThreadPoolExecutorTest {

    ExecutorService service;

    @Before
    public void setup() {
        service = Executors.newFixedThreadPool(2);
    }

    @After
    public void shutDown() {
        service.shutdownNow();
    }

    @Test
    public void testWhenTaskNoExceptionCoreThreadNotReNew() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        IntStream.range(0, 10).forEach(i -> service.execute(() -> {
            Assert.assertThat(Thread.currentThread().getName(), anyOf(equalTo("pool-1-thread-1"), equalTo("pool-1-thread-2")));
            System.out.println("work's thread: " + Thread.currentThread().getName());
            countDownLatch.countDown();
        }));
        countDownLatch.await();
    }

    @Test
    public void testWhenTaskExceptionCoreThreadNeedReNew() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        IntStream.range(0, 10).forEach(i -> service.execute(() -> {
            System.out.println("work's thread: " + Thread.currentThread().getName());
            countDownLatch.countDown();
            throw new RuntimeException();
        }));
        countDownLatch.await();
    }

    //submit 会把runnable转换为FutureTask，run方法抛出的异常会被捕获放到异常列表里，详情减FutureTask的run()方法
    @Test
    public void testWhenTaskExceptionButSubmitCoreThreadNotReNew() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        IntStream.range(0, 10).forEach(i -> service.submit(() -> {
            System.out.println("work's thread: " + Thread.currentThread().getName());
            countDownLatch.countDown();
            throw new RuntimeException();
        }));
        countDownLatch.await();
    }

}
