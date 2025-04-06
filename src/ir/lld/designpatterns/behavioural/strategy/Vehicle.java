package ir.lld.designpatterns.behavioural.strategy;

public class Vehicle {

    private DriveStrategy driveStrategy;
    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }
}
