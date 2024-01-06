package com.example.geektrust.Configure;

import com.example.geektrust.Command.CommandInvoker;
import com.example.geektrust.Command.ICommand;
import com.example.geektrust.Command.MetroCardCommand;
import com.example.geektrust.Command.PassengerCommand;
import com.example.geektrust.Command.StationCommand;
import com.example.geektrust.repository.IMetroCardRepository;
import com.example.geektrust.repository.IPassengerRepository;
import com.example.geektrust.repository.IStationRepository;
import com.example.geektrust.repository.impl.MetroCardRepoImpl;
import com.example.geektrust.repository.impl.PassengerRepoImpl;
import com.example.geektrust.repository.impl.StationRepoImpl;
import com.example.geektrust.service.IMetroCard;
import com.example.geektrust.service.IPassenger;
import com.example.geektrust.service.IStation;
import com.example.geektrust.service.impl.MetroCardServiceImpl;
import com.example.geektrust.service.impl.PassengerServiceImpl;
import com.example.geektrust.service.impl.StationServiceImpl;

public class ApplicationConfig {

    IMetroCardRepository metroCardRepository = new MetroCardRepoImpl();
    IStationRepository stationRepository = new StationRepoImpl();
    IPassengerRepository passengerRepository = new PassengerRepoImpl();

    IMetroCard metroCardService = new MetroCardServiceImpl(metroCardRepository);
    IPassenger passengerService = new PassengerServiceImpl(passengerRepository);
    IStation stationServcie = new StationServiceImpl(stationRepository);

    ICommand metroCardCommand = new MetroCardCommand(metroCardService);
    ICommand passengerCommand =
            new PassengerCommand(metroCardService, passengerService, stationServcie);
    ICommand stationCommand =
            new StationCommand(stationServcie, passengerService, metroCardService);

    CommandInvoker commandInvoker = new CommandInvoker();

    public void loadCommands() {
        commandInvoker.register("BALANCE", metroCardCommand);

        commandInvoker.register("CHECK_IN", passengerCommand);

        commandInvoker.register("PRINT_SUMMARY", stationCommand);
    }

    public CommandInvoker getCommandInvoker() {
        return commandInvoker;
    }



}

