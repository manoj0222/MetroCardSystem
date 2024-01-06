package com.example.geektrust.Command;

import java.util.List;

import com.example.geektrust.Exception.NoSuchCommandException;
import com.example.geektrust.service.IMetroCard;
import com.example.geektrust.service.IPassenger;
import com.example.geektrust.service.IStation;

public class PassengerCommand implements ICommand {

    private IMetroCard metroCardService;

    public IMetroCard getMetroCardService() {
        return metroCardService;
    }

    public void setMetroCardService(IMetroCard metroCardService) {
        this.metroCardService = metroCardService;
    }

    public IPassenger getPassengerService() {
        return passengerService;
    }

    public void setPassengerService(IPassenger passengerService) {
        this.passengerService = passengerService;
    }

    public IStation getStationServcie() {
        return stationServcie;
    }

    public void setStationServcie(IStation stationServcie) {
        this.stationServcie = stationServcie;
    }

    private IPassenger passengerService;

    private IStation stationServcie;

    public PassengerCommand(IMetroCard metroCardService, IPassenger passengerService,
            IStation stationServcie) {
        this.metroCardService = metroCardService;
        this.passengerService = passengerService;
        this.stationServcie = stationServcie;
    }

    @Override
    public void execute(List<String> tokens) {
        String command = tokens.get(0);
        String cardNumber = tokens.get(1);
        String passengerType = tokens.get(2);
        String fromStation = tokens.get(3);
        if (command != null && command.equals("CHECK_IN") && cardNumber != null
                && passengerType != null && fromStation != null) {
         passengerService.checkIn(cardNumber,passengerType,fromStation,stationServcie,metroCardService);
        } else {
            throw new NoSuchCommandException();
        }

    }

}
