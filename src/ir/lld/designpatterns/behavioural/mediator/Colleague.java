package ir.lld.designpatterns.behavioural.mediator;

public interface Colleague {

    void placeBid(int amount);
    void receiveBidNotification(int amount, String bidder);
    String getName();
}
