package dh01.research.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Time : 18-7-27 下午8:52
 * Author : hcy
 * Description :
 */
public abstract class BaseSubject implements ISubject {
    //观察者列表
    List<Subscriber> subscriberList = new ArrayList<>();

    @Override
    public void registerSubscriber(Subscriber subscriber) {
        this.subscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        this.subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        subscriberList.forEach(Subscriber::update);
    }
}
