package dh01.research.design.observer;

/**
 * Time : 18-7-27 下午8:57
 * Author : hcy
 * Description : 报社，被观察者实体
 */
public class NewsOffice extends BaseSubject{
    /**
     * 报纸来了事件，通知观察者
     */
    public void newspaperCome(){
        notifySubscribers();
    }
}
