package org.rd99;

public class Auction {
        // Your code here
        public String name;
        public Integer Id;
        public String description;
        public Integer currentBid;
        public Integer minPrice;
        public Integer maxPrice;
        public boolean isRunning;
        public Seller seller;
        public List<Integer> buyers;

        Auction(String name, Integer Id, String description, Integer currentBid, Integer minPrice, Integer maxPrice, boolean isRunning, Seller seller){
            this.name = name;
            this.Id = Id;
            this.description = description;
            this.currentBid = currentBid;
            this.minPrice =  minPrice;
            this.maxPrice =  maxPrice;
            this.isRunning = false;
            this.seller = seller;
            this.buyers = new ArrayList<>();
        }

        public void startAuction(int duration){
            this.isRunning = true;
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    this.isRunning = false;
                }
            } , duration*1000);
        }
    }
