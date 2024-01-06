package com.example.geektrust.repository.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.entity.MetroCard;
import com.example.geektrust.entity.Passenger;
import com.example.geektrust.repository.IPassengerRepository;

public class PassengerRepoImpl implements IPassengerRepository {

    private Map<String, Passenger> savedPassengerData = new HashMap<String, Passenger>();

    @Override
    public Passenger findPassengerByCardNumber(String cardNumber) {
        Passenger passenger = savedPassengerData.get(cardNumber);
        return passenger;
    }

    @Override
    public void update(MetroCard metroCard, String passenegerType) {
        Passenger passenger = null;
        if (metroCard != null && savedPassengerData.containsKey(metroCard.getMetroCardNumber())) {
            Passenger existingPassenger = findPassengerByCardNumber(metroCard.getMetroCardNumber());
            existingPassenger.setMetroCard(metroCard);
            existingPassenger
                    .setNoOfJourneyTravelled(existingPassenger.getNoOfJourneyTravelled() + 1);
            savedPassengerData.put(metroCard.getMetroCardNumber(), existingPassenger);
        } else if (metroCard != null) {
            passenger = new Passenger();
            passenger.setMetroCard(metroCard);
            passenger.setTypeOfPassenger(passenegerType);
            savedPassengerData.put(metroCard.getMetroCardNumber(), passenger);
        } else {

        }
    }

}

