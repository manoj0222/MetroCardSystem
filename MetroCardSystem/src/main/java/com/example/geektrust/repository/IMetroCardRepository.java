package com.example.geektrust.repository;

import com.example.geektrust.entity.MetroCard;

public interface IMetroCardRepository {

    void save(String cardNumber, Double balance);

    MetroCard findCardByNumber(String cardNumber);

    Double updateBalance(String metroCardNumber, Double balance);
    
}

