package ir.lld.designpatterns.behavioural.visitor;

import ir.lld.designpatterns.behavioural.visitor.impl.*;

public class VisitorDesignPattern {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        RoomVisitor pricingVisitor = new RoomPricingVisitor();
        RoomVisitor maintenanceVisitor = new RoomMaintenanceVisitor();

        // performing an operation on the objects
        singleRoom.accept(pricingVisitor);  // double dispatch, method called depends on caller object &
                                            // object passed in argument
        System.out.println(((SingleRoom)singleRoom).roomPrice);

        doubleRoom.accept(pricingVisitor);
        System.out.println(((DoubleRoom)doubleRoom).roomPrice);

        deluxeRoom.accept(pricingVisitor);
        System.out.println(((DeluxeRoom)deluxeRoom).roomPrice);

        // performing another operation on the objects

        singleRoom.accept(maintenanceVisitor);
        doubleRoom.accept(maintenanceVisitor);
        deluxeRoom.accept(maintenanceVisitor);

    }
}
