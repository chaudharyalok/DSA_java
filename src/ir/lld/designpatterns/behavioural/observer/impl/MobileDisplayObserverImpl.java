package ir.lld.designpatterns.behavioural.observer.impl;

import ir.lld.designpatterns.behavioural.observer.DisplayObserver;
import ir.lld.designpatterns.behavioural.observer.WeatherStationObservable;

public class MobileDisplayObserverImpl implements DisplayObserver {

    private WeatherStationObservable obj;
    public MobileDisplayObserverImpl(WeatherStationObservable obj){
        this.obj = obj;
    }
    @Override
    public void update() {
        System.out.println("Current temp displayed in mobile is: "+ obj.getTemp());
    }
}
