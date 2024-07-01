package org.rd99.service;

import org.apache.commons.lang3.tuple.Pair;
import org.rd99.Auction;
import org.rd99.Buyer;
import org.rd99.Seller;
import org.rd99.repo.AuctionRepo;
import org.rd99.repo.BuyerRepo;
import org.rd99.repo.SellerRepo;

import java.text.MessageFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AuctionService {
    AuctionRepo auctionRepo;
    SellerRepo sellerRepo;

    BuyerRepo buyerRepo;

    public AuctionService(AuctionRepo auctionRepo,BuyerRepo buyerRepo,SellerRepo sellerRepo){
        this.sellerRepo = sellerRepo;
        this.auctionRepo = auctionRepo;
        this.buyerRepo = buyerRepo;
    }

    public void addAuction(String name,Integer id, Integer sellerId) throws RuntimeException{
        try{
            if(!sellerRepo.getSellerMap().containsKey(sellerId)){
                throw new RuntimeException("Seller not valid");
            }
            if(auctionRepo.auctions.containsKey(id)){
                String exceptionMsg = MessageFormat.format("Auction with id : {0}" , id);
                throw new RuntimeException(exceptionMsg);
            }
            Auction auction = new Auction(name, id, sellerId);
            auctionRepo.auctions.put(id,auction);
        }catch (Error err){
            throw new RuntimeException(err);
        }
    }
    public void startAuction(int auctionId,int duration) throws RuntimeException{
        if(!auctionRepo.getAuctions().containsKey(auctionId)){
            throw new RuntimeException("auction not init.");
        }
        Auction auction = auctionRepo.getAuctions().get(auctionId);
        auction.isRunning = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                auction.isRunning = false;
            }
        }, duration * 1000L);
    }

    public void closeAuction(Integer auctionId){
        Auction auction = auctionRepo.getAuctions().get(auctionId);
        List<Pair<Integer,Integer>> pastBids = auction.pastBids;
        if(pastBids.isEmpty()){
            System.out.println("No bids placed for this auction.");
            return;
        }
        Pair<Integer,Integer> winningBid = pastBids.get(pastBids.size() -1);
        Buyer buyer = buyerRepo.getBuyerMap().get(winningBid.getLeft());
        buyer.balance -= winningBid.getRight();
        Seller seller = sellerRepo.getSellerMap().get(auction.seller);
        seller.balance += winningBid.getRight();
        auction.isRunning = false;
        System.out.println(MessageFormat.format("{0} wins bid for auction with seller {1} for {2}",buyer.name , seller.name,winningBid.getRight()));
    }
}
