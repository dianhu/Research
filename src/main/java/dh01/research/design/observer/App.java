package dh01.research.design.observer;

/**
 * Time : 18-7-27 下午8:56
 * Author : hcy
 * Description : 观察者模式应用
 * 观察者模式定义了对象之间的一对多依赖,这样一来,当一个对象改变状态时,它的所有依赖者都会收到通
 * 知并自动更新。
 */
public class App {
    public static void main(String[] args) {
        ISubject newsOffice = new NewsOffice();
        Subscriber subscriberA = new SubscriberA();
        Subscriber subscriberB = new SubscriberB();
        //被观察者注册观察者
        newsOffice.registerSubscriber(subscriberA);
        newsOffice.registerSubscriber(subscriberB);
        ((NewsOffice)newsOffice).newspaperCome();
    }
}
