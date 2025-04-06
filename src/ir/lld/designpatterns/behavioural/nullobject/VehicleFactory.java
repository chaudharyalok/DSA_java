package ir.lld.designpatterns.behavioural.nullobject;

public class VehicleFactory {

    public static Vehicle getVehicle(String vehicleType){
        if("CAR".equals(vehicleType)){
            return new Car();
        }
        return new NullObject();
    }
}
