package ir.lld.designpatterns.behavioural.visitor.impl;

import ir.lld.designpatterns.behavioural.visitor.RoomElement;
import ir.lld.designpatterns.behavioural.visitor.RoomVisitor;

public class DoubleRoom implements RoomElement {
    public int roomPrice = 0;
    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}
