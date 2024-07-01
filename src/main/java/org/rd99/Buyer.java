package org.rd99;

import org.rd99.Auction;

public class Buyer{
    public Integer balance;
    public String name;
    public Integer Id;
    public Buyer(String name, Integer Id, Integer balance){
        this.name = name;
        this.Id = Id;
        this.balance = balance;
    }
    public Buyer(String name, Integer Id){
        this.name = name;
        this.Id = Id;
        this.balance = 100;
    }
    public void bid(Auction auction, Integer bid){
        if(auction.isRunning && bid > auction.currentBid && bid <= this.balance){
            auction.currentBid = bid;
        }
    }
}