package org.rd99.repo;

import org.rd99.Buyer;

import java.util.HashMap;
import java.util.Map;

public class BuyerRepo {
    public Map<Integer, Buyer> getBuyerMap() {
        return buyerMap;
    }

    public Map<Integer, Buyer> buyerMap;

    public BuyerRepo(){
        buyerMap = new HashMap<>();
    }

}