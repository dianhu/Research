package dh01.research.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Time : 18-7-27 下午9:04
 * Author : hcy
 * Description :
 */
public class SubscriberA implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我是订阅者A,我收到报纸。");
    }
}
