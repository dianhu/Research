package dh01.research.design.observer;

/**
 * Time : 18-7-27 下午8:40
 * Author : hcy
 * Description : 主题，观察者模式中为被观察者
 */
public interface ISubject {
    /**
     * 注册订阅者
     * @param subscriber
     * @return
     */
    void registerSubscriber(Subscriber subscriber);

    /**
     * 移除订阅者
     * @param subscriber
     */
    void removeSubscriber(Subscriber subscriber);

    /**
     * 通知所有订阅者
     */
    void notifySubscribers();

}
