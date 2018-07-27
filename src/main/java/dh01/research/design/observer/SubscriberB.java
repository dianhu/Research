package dh01.research.design.observer;

/**
 * Time : 18-7-27 下午8:48
 * Author : hcy
 * Description :
 */
public class SubscriberB implements Subscriber {
    @Override
    public void update() {
        System.out.println("我是订阅者B,我收到报纸。");
    }
}
