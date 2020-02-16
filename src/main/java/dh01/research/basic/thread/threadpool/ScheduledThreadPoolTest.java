package dh01.research.basic.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Time : 20-2-16 下午2:18
 * Author : hcy
 * Description : 原理参考 https://gitbook.cn/books/5c6d181f3a97595900948602/index.html
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {

        //core设置为1，同一时刻只会有一个线程去运行定时任务，线程不会新增
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        IntStream.range(0, 2).forEach(i -> service.scheduleWithFixedDelay(() -> {
            try {
                //System.out.println("enter");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //任务需要捕获异常，否则下个任务不会继续执行
            //int n = 1 / 0;
            System.out.println(Thread.currentThread().getName() + " " + i + " run.... " + System.currentTimeMillis());
        }, 1000, 2000, TimeUnit.MILLISECONDS));

    }
}
