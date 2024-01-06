package com.example.geektrust.service.impl;

import com.example.geektrust.entity.MetroCard;
import com.example.geektrust.repository.IMetroCardRepository;
import com.example.geektrust.service.IMetroCard;

public class MetroCardServiceImpl implements IMetroCard {

    private IMetroCardRepository metroCardRepository;


    public MetroCardServiceImpl(IMetroCardRepository metroCardRepository) {
        this.metroCardRepository = metroCardRepository;
    }

    @Override
    public void creditAmount(String cardNumber, Double balance) {
        MetroCard metroCard = this.metroCardRepository.findCardByNumber(cardNumber);
        if (metroCard != null) {
            Double newBalance =
                    this.metroCardRepository.updateBalance(metroCard.getMetroCardNumber(), balance);
        } else {
            this.metroCardRepository.save(cardNumber, balance);
        }

    }

    @Override
    public MetroCard findCardByNumber(String cardNumber) {
        MetroCard metroCard = this.metroCardRepository.findCardByNumber(cardNumber);
        return metroCard;
    }

}
