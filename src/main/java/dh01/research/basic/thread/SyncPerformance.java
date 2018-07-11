package dh01.research.basic.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Time : 18-7-11 下午20:06
 * Author : hcy
 * Description : 同步方法性能对比
 */
public class SyncPerformance {

    public static void main(String[] args) throws InterruptedException {
        testCounter(new UnSyncCounter());
        testCounter(new AtomicCounter());
        testCounter(new SyncCounter());
        testCounter(new LockCounter());
        testCounter(new CASCounter());
    }
    interface Counter{
        void increment();
        long getCounter();
    }

    static void testCounter(Counter counter) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1000);
        long start = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            service.submit(new CounterRunnable(counter,100000));
        }
        service.shutdown();
        service.awaitTermination(1,TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println(counter+" Counter : "+counter.getCounter() );
        System.out.println(counter+" Time : "+(end-start));
    }

    private static Unsafe getUnsafe(){
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    static class CounterRunnable implements Runnable{
        private final Counter counter;
        private final int num;
        CounterRunnable(Counter counter,int num){
            this.counter = counter;
            this.num = num;
        }
        @Override
        public void run() {
            for(int i=0;i<num;i++){
                counter.increment();
            }
        }
    }

    static class UnSyncCounter implements Counter{
        private int counter = 0;
        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class AtomicCounter implements Counter{
        private AtomicInteger counter = new AtomicInteger(0);
        @Override
        public void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }

    static class SyncCounter implements Counter{
        private int counter = 0;
        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class LockCounter implements Counter{
        private int counter = 0;
        Lock lock = new ReentrantLock();
        @Override
        public void increment() {
            try {
                lock.lock();
                counter++;
            }finally {
                lock.unlock();
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class CASCounter implements Counter{
        private volatile int counter = 0;
        private Unsafe unsafe;
        private long valueOffset;
        public CASCounter(){
            unsafe = getUnsafe();
            try {
                valueOffset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void increment() {
            int current = counter;
            while (!unsafe.compareAndSwapInt(this,valueOffset,current,current+1)){
                current = counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

}
