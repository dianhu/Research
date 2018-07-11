package dh01.research.basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * Time : 18-7-10 下午7:31
 * Author : hcy
 * Description : volatile可见性
 */
public class VolatileVisible {
    final static int MAX = 5;
    static int init_value = 0;
    //static volatile int init_value = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (init_value != localValue) {
                    System.out.printf("init_value is updated to [%d]\n", init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                System.out.printf("init_value will be changed to [%d]\n", ++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }

}
