package org.rd99.repo;

import org.rd99.Seller;

import java.util.HashMap;
import java.util.Map;

public class SellerRepo {
    public Map<Integer, Seller> getSellerMap() {
        return sellerMap;
    }
    public SellerRepo(){
        sellerMap = new HashMap<>();
    }

    public Map<Integer, Seller> sellerMap ;

}