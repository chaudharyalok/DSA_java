package ir.lld.designpatterns.behavioural.strategy;

public class OffroadDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("OffroadDriveStrategy adopted");
    }
}
