package ir.lld.designpatterns.behavioural.visitor;

public interface RoomElement {

    public void accept(RoomVisitor roomVisitor);
}
