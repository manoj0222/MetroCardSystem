package com.example.geektrust.entity;

public class Passenger {


    @Override
    public String toString() {
        return "Passenger [metroCard=" + metroCard + ", noOfJourneyTravelled="
                + noOfJourneyTravelled + ", typeOfPassenger=" + typeOfPassenger + "]";
    }

    public MetroCard getMetroCard() {
        return metroCard;
    }

    public void setMetroCard(MetroCard metroCard) {
        this.metroCard = metroCard;
    }

    public String getTypeOfPassenger() {
        return typeOfPassenger;
    }

    public void setTypeOfPassenger(String typeOfPassenger) {
        this.typeOfPassenger = typeOfPassenger;
    }

    public Integer getNoOfJourneyTravelled() {
        return noOfJourneyTravelled;
    }

    public void setNoOfJourneyTravelled(Integer noOfJourneyTravelled) {
        this.noOfJourneyTravelled = noOfJourneyTravelled;
    }

    private MetroCard metroCard;

    private String typeOfPassenger;

    private Integer noOfJourneyTravelled;



}

