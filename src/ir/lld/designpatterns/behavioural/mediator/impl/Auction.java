package ir.lld.designpatterns.behavioural.mediator.impl;

import ir.lld.designpatterns.behavioural.mediator.AuctionMediator;
import ir.lld.designpatterns.behavioural.mediator.Colleague;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator {

    List<Colleague> colleagues = new ArrayList<>();
    @Override
    public void addBidder(Colleague bidder) {
        colleagues.add(bidder);
    }

    @Override
    public void placeBid(Colleague bidder, int bidAmount) {

        for(Colleague colleague : colleagues){
            if(!bidder.getName().equals(colleague.getName())){
                colleague.receiveBidNotification(bidAmount, bidder.getName());
            }
        }
    }
}
