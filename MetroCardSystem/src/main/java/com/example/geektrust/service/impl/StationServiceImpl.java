package com.example.geektrust.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.example.geektrust.Dto.PrintSummaryDto;
import com.example.geektrust.Utils.MetroCardSystemConstants;
import com.example.geektrust.Utils.PassengerSummarySort;
import com.example.geektrust.Utils.StationServcieImplUtil;
import com.example.geektrust.entity.Station;
import com.example.geektrust.repository.IStationRepository;
import com.example.geektrust.service.IStation;

public class StationServiceImpl implements IStation {

    private IStationRepository stationRepository;
    private StationServcieImplUtil stationServcieImplUtil = new StationServcieImplUtil();
    String[] passengrType = {MetroCardSystemConstants.ADULT, MetroCardSystemConstants.KID,
            MetroCardSystemConstants.SENIOR_CITIZEN};

    public StationServiceImpl(IStationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    /*
     * 
     */
    @Override
    public void printSummary() {
        // Fetch all the Station related Data
        Map<String, Station> stationsData = this.stationRepository.findAll();
        // Iterate through each station Data.
        for (Entry<String, Station> eachEntry : stationsData.entrySet()) {
            // Printing the totalCollection line with station related data.
            System.out.println(MetroCardSystemConstants.TOTAL_COLLECTION + " "
                    + eachEntry.getValue().getTotalCollectionAmount() + " "
                    + eachEntry.getValue().getTotalDiscount());
            // Printing only PASSENGER_TYPE_SUMMARY line
            System.out.println(MetroCardSystemConstants.PASSENGER_TYPE_SUMMARY);
            // Segregating the PassengerType along with noofPerson traveled.
            basedOnThePassengerCounter(eachEntry.getValue().getNoOfAdultTravelled(),
                    eachEntry.getValue().getNoOfKidTravelled(),
                    eachEntry.getValue().getNoOfSeniorCitizenTravelled());

        }

    }


    /**
     * These method based on the input parameters will create a list of PrintSummaryDto and also
     * sort based on the given criteria. criteria:- i)We have to print the passenger type and count
     * based on the count(Descending sorting order). ii)If any passenger types are having same
     * count means we have to sort based on natural sort of the passengerTypes.
     * 
     * @param noOfAdultTravelled
     * @param noOfKidTravelled
     * @param noOfSeniorCitizenTravelled
     */
    private void basedOnThePassengerCounter(Integer noOfAdultTravelled, Integer noOfKidTravelled,
            Integer noOfSeniorCitizenTravelled) {
        List<PrintSummaryDto> list_ofPassenger = new ArrayList();
        // Iterate for the Different Passenger Types.
        for (int i = 0; i < passengrType.length; i++) {
            PrintSummaryDto aPrintSummaryDto = new PrintSummaryDto();
            // if PassengerType is ADULT
            if (passengrType[i].equals(MetroCardSystemConstants.ADULT)) {
                aPrintSummaryDto.setPassenegerType(MetroCardSystemConstants.ADULT);
                aPrintSummaryDto.setCount(noOfAdultTravelled);
                // else if PassengerType is KID
            } else if (passengrType[i].equals(MetroCardSystemConstants.KID)) {
                aPrintSummaryDto.setPassenegerType(MetroCardSystemConstants.KID);
                aPrintSummaryDto.setCount(noOfKidTravelled);
                // PassengerType is SENIOR_CITIZEN
            } else {
                aPrintSummaryDto.setPassenegerType(MetroCardSystemConstants.SENIOR_CITIZEN);
                aPrintSummaryDto.setCount(noOfSeniorCitizenTravelled);
            }
            list_ofPassenger.add(aPrintSummaryDto);
        }
        // Sort the PassengerSummarySort based on the criteria.
        Collections.sort(list_ofPassenger, new PassengerSummarySort());
        // Printing the printSummaryDto.
        for (PrintSummaryDto printSummaryDto : list_ofPassenger) {
            System.out.println(
                    printSummaryDto.getPassenegerType() + " " + printSummaryDto.getCount());
        }
    }

    /**
     * 
     * @param fromStation
     * @param discountAmount
     * @param travelCharges
     * @param shortAgeAmount
     * @param passengerType
     */

    @Override
    public void updateStation(String fromStation, Double discountAmount, Double travelCharges,
            Double shortAgeAmount, String passengerType) {
        // check whether the station is alreday registered or not.
        Station existingStation = this.stationRepository.findStationByName(fromStation);
        // if yes the update the data.
        if (existingStation != null) {
            this.stationServcieImplUtil.checkTheTypeOfPasseneger(existingStation, passengerType);
            existingStation.setTotalCollectionAmount(
                    existingStation.getTotalCollectionAmount() + travelCharges + shortAgeAmount);
            existingStation.setTotalDiscount(existingStation.getTotalDiscount() + discountAmount);
            this.stationRepository.updateStation(fromStation, existingStation);
        }
        // else create station instance and save the data.
        else {
            Station station = new Station();
            station.setTotalCollectionAmount(
                    station.getTotalCollectionAmount() + travelCharges + shortAgeAmount);
            this.stationServcieImplUtil.checkTheTypeOfPasseneger(station, passengerType);
            this.stationRepository.updateStation(fromStation, station);
        }
    }



}
