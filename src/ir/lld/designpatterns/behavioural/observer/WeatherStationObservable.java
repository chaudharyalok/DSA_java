package ir.lld.designpatterns.behavioural.observer;

public interface WeatherStationObservable {

    public void add(DisplayObserver obj);
    public void remove(DisplayObserver obj);
    public void notifyDisplay();
    public void setTemp(int temp);
    public int getTemp();

}
