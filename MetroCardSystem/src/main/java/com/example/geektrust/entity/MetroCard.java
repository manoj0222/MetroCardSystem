package com.example.geektrust.entity;

public class MetroCard {

    private String metroCardNumber;

    private double balance;


    
    public MetroCard(){
        
    }

    public String getMetroCardNumber() {
        return metroCardNumber;
    }

    public void setMetroCardNumber(String metroCardNumber) {
        this.metroCardNumber = metroCardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "MetroCard [balance=" + balance + ", metroCardNumber=" + metroCardNumber + "]";
    }


    
}

