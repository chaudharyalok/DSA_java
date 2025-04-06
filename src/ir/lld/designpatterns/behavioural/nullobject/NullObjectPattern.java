package ir.lld.designpatterns.behavioural.nullobject;

public class NullObjectPattern {

    public static void main(String arr[]){

        Vehicle vehicle = VehicleFactory.getVehicle("BIKE");
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle){
        // here we don't need to check if vehicle is not null check anymore
        System.out.println("Seating capacity: " + vehicle.getSeatingCapacity());
        System.out.println("Fuel tank capacity: " + vehicle.getFuelTankCapacity());
    }
}
