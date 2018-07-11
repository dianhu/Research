package dh01.research.basic.thread.simple;

/** 
 * 技巧： 
 *      1.在当前线程里执行threadLocal.set(value) 相当于 currentThread.threadLocalMap.set(threadLocal,value)。 
 *          即：每个线程均含有一个threadLocalMap变量，该变量由ThreadLocal维护。 
 */  
public class ThreadLocalDemo {  
  
    private static ThreadLocal<String> myData = new ThreadLocal<String>();  
  
    public static void main(String[] args) {  
        Thread t1 = new Thread(new Runnable(){  
            public void run() {  
                System.out.println("Thread " + Thread.currentThread().getName() + "[begin] has " + myData.get());  
                myData.set("t1");  
                System.out.println("Thread " + Thread.currentThread().getName() + "[end] has " + myData.get());  
            }  
        });  
        Thread t2 = new Thread(new Runnable(){  
            public void run() {  
                System.out.println("Thread " + Thread.currentThread().getName() + "[begin] has " + myData.get());  
                myData.set("t2");  
                System.out.println("Thread " + Thread.currentThread().getName() + "[end] has " + myData.get());  
            }  
        });  
        t1.start();  
        t2.start();  
    }  
}  
