package dh01.research.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Time : 18-7-27 下午8:56
 * Author : hcy
 * Description : 观察者模式应用
 */
public class App {
    public static void main(String[] args) {
        Observable newsOffice = new NewsOffice();
        Observer subscriberA = new SubscriberA();
        Observer subscriberB = new SubscriberB();
        //被观察者注册观察者
        newsOffice.addObserver(subscriberA);
        newsOffice.addObserver(subscriberB);
        ((NewsOffice)newsOffice).newspaperCome();
    }
}
