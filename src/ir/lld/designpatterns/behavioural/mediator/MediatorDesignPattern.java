package ir.lld.designpatterns.behavioural.mediator;

import ir.lld.designpatterns.behavioural.mediator.impl.Auction;
import ir.lld.designpatterns.behavioural.mediator.impl.Bidder;

public class MediatorDesignPattern {

    public static void main(String[] args) {
        AuctionMediator auction =  new Auction();

        Colleague bidder1 = new Bidder("bidder1",auction);
        Colleague bidder2 = new Bidder("bidder2",auction);

        bidder1.placeBid(10);
        bidder2.placeBid(20);

    }
}
