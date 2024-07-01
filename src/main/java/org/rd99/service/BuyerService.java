package org.rd99.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.rd99.Auction;
import org.rd99.Buyer;
import org.rd99.repo.AuctionRepo;
import org.rd99.repo.BuyerRepo;

import java.text.MessageFormat;

public class BuyerService{
    BuyerRepo buyerRepo;
    AuctionRepo auctionRepo;
    public BuyerService(BuyerRepo buyerRepo, AuctionRepo auctionRepo){
        this.auctionRepo = auctionRepo;
        this.buyerRepo = buyerRepo;
    }

    public void addBuyer(Integer id) throws Exception {
        if(buyerRepo.getBuyerMap().containsKey(id)){
            throw new RuntimeException("User already present");
        }

        String randName = RandomStringUtils.randomAlphabetic(6);
        Buyer buyerWithCurrId = new Buyer(randName,id);
        buyerRepo.getBuyerMap().put(id,buyerWithCurrId);
    }

    public boolean placeBid(Integer auctionId,Integer userId , Integer amount) throws RuntimeException {
        if(!auctionRepo.getAuctions().containsKey(auctionId)){
            throw new RuntimeException("No such Auction running");
        }
        if(!buyerRepo.getBuyerMap().containsKey(userId)){
            throw new RuntimeException("Invalid Buyer");
        }
        Auction currAuction = auctionRepo.getAuctions().get(auctionId);
        Buyer buyer = buyerRepo.getBuyerMap().get(userId);
        if(currAuction.isRunning && currAuction.currentBid < amount && buyer.balance >= amount){
            //valid bid
            currAuction.pastBids.add(Pair.of(userId,amount));
            System.out.println(MessageFormat.format("buyer {0} bids {1}",buyer.name , amount));
            return true;
        }
        return false;
    }






}