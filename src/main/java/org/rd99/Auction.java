package org.rd99;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Auction {
    // Your code here
    public String name;
    public Integer Id;
    public String description;
    public Integer currentBid;
    public Integer minPrice;
    public Integer maxPrice;
    public boolean isRunning;
    public Integer seller;
    public List<Integer> buyers;

    public List<Pair<Integer , Integer>> pastBids;

    Auction(String name, Integer Id, String description, Integer currentBid, Integer minPrice, Integer maxPrice,
            boolean isRunning, Integer sellerId) {
        this.name = name;
        this.Id = Id;
        this.description = description;
        this.currentBid = 0;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.isRunning = false;
        this.seller = sellerId;
        this.buyers = new ArrayList<>();
        this.pastBids = new ArrayList<>();
    }

    public Auction(String name, Integer id, Integer sellerId){
         this(name,id,RandomStringUtils.randomAlphabetic(10),0,0,Integer.MAX_VALUE,false,sellerId);
    }

    public void addBuyer(){

    }
}
