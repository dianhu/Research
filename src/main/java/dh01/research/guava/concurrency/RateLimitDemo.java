package dh01.research.guava.concurrency;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Time : 20-2-11 上午12:07
 * Author : hcy
 * Description :
 */
public class RateLimitDemo {
    //每秒产生的最大令牌数为2，以固定频率生产
    private static RateLimiter rateLimiter = RateLimiter.create(60);
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        IntStream.range(0,10).forEach(i->{
            service.submit(RateLimitDemo::testLimiter);
        });
    }

    private static void testLimiter(){
        //每次取2个令牌，没有则阻塞等待，直到获取2个令牌后恢复阻塞
        System.out.println(Thread.currentThread()+" waiting "+ rateLimiter.acquire(120));
    }
}
