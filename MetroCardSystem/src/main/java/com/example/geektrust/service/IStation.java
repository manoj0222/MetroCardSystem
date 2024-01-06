package com.example.geektrust.service;

public interface IStation {

    void printSummary();

    void updateStation(String fromStation, Double discountAmount, Double travelCharges,
            Double shortAgeAmount, String passengerType);

    
    
}
