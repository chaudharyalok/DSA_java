package ir.lld.designpatterns.behavioural.visitor.impl;

import ir.lld.designpatterns.behavioural.visitor.RoomVisitor;

public class RoomPricingVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Price computation of single room");
        singleRoom.roomPrice = 10;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Price computation of double room");
        doubleRoom.roomPrice = 20;
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Price computation of deluxe room");
        deluxeRoom.roomPrice = 30;
    }
}
