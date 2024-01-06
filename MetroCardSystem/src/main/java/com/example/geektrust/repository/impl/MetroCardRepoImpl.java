package com.example.geektrust.repository.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.entity.MetroCard;
import com.example.geektrust.repository.IMetroCardRepository;

public class MetroCardRepoImpl implements IMetroCardRepository {

    private Map<String, MetroCard> savedCardData = new HashMap<>();

    @Override
    public void save(String cardNumber, Double balance) {
        MetroCard metroCard = new MetroCard();
        metroCard.setMetroCardNumber(cardNumber);
        metroCard.setBalance(balance);
        savedCardData.put(cardNumber, metroCard);

    }

    @Override
    public MetroCard findCardByNumber(String cardNumber) {
        MetroCard metroCard = savedCardData.get(cardNumber);
        return metroCard;
    }

    @Override
    public Double updateBalance(String metroCardNumber, Double balance) {
        MetroCard metroCard = savedCardData.get(metroCardNumber);
        Double newBalance = metroCard.getBalance()+balance;
        metroCard.setBalance(newBalance);
        savedCardData.put(metroCardNumber, metroCard);
        return newBalance;
    }

}

