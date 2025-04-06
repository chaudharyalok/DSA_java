package ir.lld.designpatterns.behavioural.strategy;

public class NormalVehicle extends Vehicle {
    public NormalVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }

}
