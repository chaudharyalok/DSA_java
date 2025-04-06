package ir.lld.designpatterns.behavioural.observer;

import ir.lld.designpatterns.behavioural.observer.impl.MobileDisplayObserverImpl;
import ir.lld.designpatterns.behavioural.observer.impl.TVDisplayObserverImpl;
import ir.lld.designpatterns.behavioural.observer.impl.WeatherStationObservableImpl;

public class ObserverPattern {

    public static void main(String arr[]){
        WeatherStationObservable weatherStationObservableImpl = new WeatherStationObservableImpl();
        DisplayObserver mobile = new MobileDisplayObserverImpl(weatherStationObservableImpl);
        DisplayObserver tv = new TVDisplayObserverImpl(weatherStationObservableImpl);

        weatherStationObservableImpl.add(mobile);
        weatherStationObservableImpl.add(tv);

        weatherStationObservableImpl.setTemp(10);
        weatherStationObservableImpl.setTemp(20);
        weatherStationObservableImpl.setTemp(30);
        weatherStationObservableImpl.setTemp(30);

    }
}


