package org.rd99.repo;

import org.rd99.Auction;

import java.util.HashMap;
import java.util.Map;

public class AuctionRepo {
    public Map<Integer, Auction> getAuctions() {
        return auctions;
    }

    public Map<Integer, Auction> auctions;


    public AuctionRepo(){
        auctions = new HashMap<>();
    }


}