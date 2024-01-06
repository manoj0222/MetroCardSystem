package com.example.geektrust.service;

import com.example.geektrust.entity.MetroCard;

public interface IMetroCard {

    void creditAmount(String cardNumber, Double balance);

    MetroCard findCardByNumber(String cardNumber);
    
}
