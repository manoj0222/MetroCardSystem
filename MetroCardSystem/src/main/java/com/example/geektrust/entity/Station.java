package com.example.geektrust.entity;

public class Station {



    private String stationName;

    private Integer noOfAdultTravelled;

    private Integer noOfKidTravelled;

    private Integer noOfSeniorCitizenTravelled;

    private Double totalCollectionAmount;

    private Double totalDiscount;

    public Station() {

    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Double getTotalCollectionAmount() {
        return totalCollectionAmount;
    }

    public void setTotalCollectionAmount(Double totalCollectionAmount) {
        this.totalCollectionAmount = totalCollectionAmount;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Integer getNoOfAdultTravelled() {
        return noOfAdultTravelled;
    }

    public void setNoOfAdultTravelled(Integer noOfAdultTravelled) {
        this.noOfAdultTravelled = noOfAdultTravelled;
    }

    public Integer getNoOfKidTravelled() {
        return noOfKidTravelled;
    }

    public void setNoOfKidTravelled(Integer noOfKidTravelled) {
        this.noOfKidTravelled = noOfKidTravelled;
    }

    public Integer getNoOfSeniorCitizenTravelled() {
        return noOfSeniorCitizenTravelled;
    }

    public void setNoOfSeniorCitizenTravelled(Integer noOfSeniorCitizenTravelled) {
        this.noOfSeniorCitizenTravelled = noOfSeniorCitizenTravelled;
    }


    @Override
    public String toString() {
        return "Station [noOfAdultTravelled=" + noOfAdultTravelled + ", noOfKidTravelled="
                + noOfKidTravelled + ", noOfSeniorCitizenTravelled=" + noOfSeniorCitizenTravelled
                + ", stationName=" + stationName + ", totalCollectionAmount="
                + totalCollectionAmount + ", totalDiscount=" + totalDiscount + "]";
    }



}

