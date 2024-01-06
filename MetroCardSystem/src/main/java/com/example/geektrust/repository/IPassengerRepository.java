package com.example.geektrust.repository;

import com.example.geektrust.entity.MetroCard;
import com.example.geektrust.entity.Passenger;

public interface IPassengerRepository {

    Passenger findPassengerByCardNumber(String cardNumber);

    void update(MetroCard metroCard,String passenegerType);
    
}
