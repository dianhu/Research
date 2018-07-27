package dh01.research.design.observer.jdk;

import java.util.Observable;

/**
 * Time : 18-7-27 下午9:03
 * Author : hcy
 * Description :
 */
public class NewsOffice extends Observable {
    public void newspaperCome(){
        this.setChanged();
        notifyObservers();
    }
}
