package ir.lld.designpatterns.behavioural.mediator;

public interface AuctionMediator {
    void addBidder(Colleague bidder);
    void placeBid(Colleague bidder, int bidAmount);
}
