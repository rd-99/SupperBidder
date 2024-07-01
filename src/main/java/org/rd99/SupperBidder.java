package org.rd99;

import org.rd99.repo.AuctionRepo;
import org.rd99.repo.BuyerRepo;
import org.rd99.repo.SellerRepo;
import org.rd99.service.AuctionService;
import org.rd99.service.BuyerService;
import org.rd99.service.SellerService;

public class SupperBidder{

    public AuctionRepo auctionRepo;
    public BuyerRepo buyerRepo;
    public SellerRepo sellerRepo;
    AuctionService auctionService;
    BuyerService buyerService;

    SellerService sellerService;
    public SupperBidder(){
        this.sellerRepo = new SellerRepo();
        this.auctionRepo = new AuctionRepo();
        this.buyerRepo = new BuyerRepo();
        this.auctionService = new AuctionService(auctionRepo,buyerRepo,sellerRepo);
        this.buyerService = new BuyerService(buyerRepo , auctionRepo);
        this.sellerService = new SellerService(this.sellerRepo);
    }

}