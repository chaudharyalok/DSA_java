package ir.lld.designpatterns.behavioural.observer.impl;

import ir.lld.designpatterns.behavioural.observer.DisplayObserver;
import ir.lld.designpatterns.behavioural.observer.WeatherStationObservable;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationObservableImpl implements WeatherStationObservable {
    List<DisplayObserver> observers;
    int temp;

    public WeatherStationObservableImpl(){
        this.observers = new ArrayList<>();
    }


    @Override
    public void add(DisplayObserver obj) {
        observers.add(obj);
    }

    @Override
    public void remove(DisplayObserver obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyDisplay() {

        for(DisplayObserver obj : observers){
            obj.update();
        }
    }

    @Override
    public void setTemp(int updatedTemp) {
       if(temp != updatedTemp){
           temp = updatedTemp;
           notifyDisplay();
       }
    }

    @Override
    public int getTemp() {
        return temp;
    }
}
