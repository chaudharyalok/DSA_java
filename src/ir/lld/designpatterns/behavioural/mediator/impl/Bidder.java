package ir.lld.designpatterns.behavioural.mediator.impl;

import ir.lld.designpatterns.behavioural.mediator.AuctionMediator;
import ir.lld.designpatterns.behavioural.mediator.Colleague;



public class Bidder implements Colleague {


    String name;
    AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int amount) {
        auctionMediator.placeBid(this, amount);
    }

    @Override
    public void receiveBidNotification(int amount, String bidder) {
        System.out.println("Bidder: " + getName() + " got the notification that " + bidder + " has put a bid of : " + amount);

    }

    @Override
    public String getName() {
        return name;
    }
}
