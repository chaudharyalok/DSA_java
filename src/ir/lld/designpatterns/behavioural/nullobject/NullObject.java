package ir.lld.designpatterns.behavioural.nullobject;

public class NullObject implements Vehicle{
    @Override
    public int getSeatingCapacity() {
        return 0;
    }

    @Override
    public int getFuelTankCapacity() {
        return 0;
    }
}
