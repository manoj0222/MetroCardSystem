package com.example.geektrust.Dto;

public class PrintSummaryDto {

    public String getPassenegerType() {
        return passenegerType;
    }

    public void setPassenegerType(String passenegerType) {
        this.passenegerType = passenegerType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private String passenegerType;

    private Integer count;

}
