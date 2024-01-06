package com.example.geektrust.Command;

import java.util.List;

import com.example.geektrust.service.IMetroCard;

public class MetroCardCommand implements ICommand {

    private IMetroCard metroCardService;

    public MetroCardCommand(IMetroCard metroCardService) {
        this.metroCardService = metroCardService;
    }

    public IMetroCard getMetroCardService() {
        return metroCardService;
    }

    public void setMetroCardService(IMetroCard metroCardService) {
        this.metroCardService = metroCardService;
    }

    @Override
    public void execute(List<String> tokens) {
        String command = tokens.get(0);
        String cardNumber = tokens.get(1);
        Double balance = Double.valueOf(tokens.get(2));
        if (command != null && command.equals("BALANCE") && cardNumber != null) {
            metroCardService.creditAmount(cardNumber, balance);
        } else {
            System.out.println("Command Not Found");
        }

    }



}
