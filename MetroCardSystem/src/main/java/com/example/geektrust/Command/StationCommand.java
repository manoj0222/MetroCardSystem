package com.example.geektrust.Command;

import java.util.List;

import com.example.geektrust.Exception.NoSuchCommandException;
import com.example.geektrust.service.IMetroCard;
import com.example.geektrust.service.IPassenger;
import com.example.geektrust.service.IStation;

public class StationCommand implements ICommand {

    private IStation stationServcie;

    private IPassenger passengerService;

    private IMetroCard metroCardService;

    public IStation getStationServcie() {
        return stationServcie;
    }

    public void setStationServcie(IStation stationServcie) {
        this.stationServcie = stationServcie;
    }

    public IPassenger getPassengerService() {
        return passengerService;
    }

    public void setPassengerService(IPassenger passengerService) {
        this.passengerService = passengerService;
    }

    public IMetroCard getMetroCardService() {
        return metroCardService;
    }

    public void setMetroCardService(IMetroCard metroCardService) {
        this.metroCardService = metroCardService;
    }


    public StationCommand(IStation stationServcie, IPassenger passengerService,
            IMetroCard metroCardService) {
        this.metroCardService = metroCardService;
        this.passengerService = passengerService;
        this.stationServcie = stationServcie;
    }

    @Override
    public void execute(List<String> tokens) {
        String command = tokens.get(0);
        if (command.equals("PRINT_SUMMARY")) {
            stationServcie.printSummary();
        } else {
            throw new NoSuchCommandException();
        }
    }


}
