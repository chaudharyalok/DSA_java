package ir.lld.designpatterns.behavioural.visitor;

import ir.lld.designpatterns.behavioural.visitor.impl.DeluxeRoom;
import ir.lld.designpatterns.behavioural.visitor.impl.DoubleRoom;
import ir.lld.designpatterns.behavioural.visitor.impl.SingleRoom;

public interface RoomVisitor {
    public void visit(SingleRoom singleRoom);
    public void visit(DoubleRoom doubleRoom);
    public void visit(DeluxeRoom deluxeRoom);
}
