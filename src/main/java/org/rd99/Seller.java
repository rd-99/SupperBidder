package org.rd99;

public class Seller{
    public Integer balance;
    public String name;
    public Integer Id;
    public Seller(String name, Integer Id){
        this.name = name;
        this.Id = Id;
        this.balance = 0;
    }
}