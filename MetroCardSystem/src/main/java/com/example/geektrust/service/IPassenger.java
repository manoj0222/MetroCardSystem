package com.example.geektrust.service;

public interface IPassenger {

    void checkIn(String cardNumber, String passengerType, String fromStation,
            IStation stationServcie, IMetroCard metroCardService);
    
}
