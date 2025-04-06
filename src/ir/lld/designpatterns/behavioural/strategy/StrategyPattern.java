package ir.lld.designpatterns.behavioural.strategy;

public class StrategyPattern {

    public static void main(String arr[]){

        DriveStrategy driveStrategy = new NormalDriveStrategy();
        Vehicle offRoadVehicle = new OffroadVehicle(driveStrategy);
        Vehicle normalVehicle = new NormalVehicle(driveStrategy);
        normalVehicle.drive();
        offRoadVehicle.drive();

    }
}
