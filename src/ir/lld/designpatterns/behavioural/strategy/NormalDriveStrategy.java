package ir.lld.designpatterns.behavioural.strategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("NormalDriveStrategy adopted");
    }
}
