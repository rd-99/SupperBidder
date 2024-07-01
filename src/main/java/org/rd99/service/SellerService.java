package org.rd99.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.rd99.Buyer;
import org.rd99.Seller;
import org.rd99.repo.SellerRepo;

public class SellerService{
    SellerRepo sellerRepo;

    public SellerService(SellerRepo sellerRepo){
        this.sellerRepo = sellerRepo;
    }

    public Seller addSeller(Integer id) throws Exception {
        if(sellerRepo.getSellerMap().containsKey(id)){
            throw new RuntimeException("Seller already present");
        }
        String randName = RandomStringUtils.randomAlphabetic(6);
        Seller sellerWithCurrId = new Seller(randName,id);
        sellerRepo.getSellerMap().put(id,sellerWithCurrId);
        return sellerWithCurrId;
    }

}