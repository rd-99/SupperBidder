package org.rd99;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        SupperBidder supperBidder = new SupperBidder();
        System.out.println("Hello World");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.nextLine();
            System.out.println(input);
            String[] commands = input.trim().split(",");
            System.out.println(Arrays.toString(commands));
//            if(commands.length >4 ||  commands.length < 3){
//                throw new Exception("improper commands");
//            }
//            else{
                switch (commands[0]){
                    case "CREATE AUCTION": {
                        String name = commands[1];
                        Integer currId = Integer.parseInt(commands[2]);
                        Integer sellerID = Integer.parseInt(commands[3]);
                        supperBidder.auctionService.addAuction(name,currId,sellerID);
                        break;
                    }
                    case "CREATE BUYER": {
                        System.out.println(99);
                        Integer currId = Integer.parseInt(commands[1]);
                        supperBidder.buyerService.addBuyer(currId);
                        break;

                    }
                    case "CREATE SELLER":{
                        Integer currId = Integer.parseInt(commands[1]);
                        supperBidder.sellerService.addSeller(currId);
                        break;

                    }

                    case "PLACE BID":
                    {
                        System.out.println(9);
                        Integer aucId = Integer.parseInt(commands[1]);
                        Integer buyerId = Integer.parseInt(commands[2]);
                        Integer amount = Integer.parseInt(commands[3]);
                        supperBidder.buyerService.placeBid(aucId,buyerId,amount);
                        break;

                    }
                    case "START AUCTION":{
                        int aucId = Integer.parseInt(commands[1]);
                        int duration = Integer.parseInt(commands[2]);
                        supperBidder.auctionService.startAuction(aucId,duration);
                        break;


                    }
                    case "CLOSE AUCTION":{
                        int aucId = Integer.parseInt(commands[1]);
                        supperBidder.auctionService.closeAuction(aucId);
                        break;

                    }
                    default:
                        throw new RuntimeException("Invalid Command");
                }

        }
        
    }
}