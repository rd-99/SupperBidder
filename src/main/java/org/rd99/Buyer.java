public class Buyer{
    public Integer balance;
    public String name;
    public Integer Id;
    public Buyer(String name, Integer Id, Integer balance){
        this.name = name;
        this.Id = Id;
        this.balance = balance;
    }
    public void bid(Auction auction, Integer bid){
        if(auction.isRunning && bid > auction.currentBid && bid <= this.balance){
            auction.currentBid = bid;
        }
    }
}