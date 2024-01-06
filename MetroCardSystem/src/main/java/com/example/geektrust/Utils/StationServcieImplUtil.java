package com.example.geektrust.Utils;

import com.example.geektrust.entity.Station;

public class StationServcieImplUtil {

    /**
     * The function is used for the increase counter of different passengerType based on the input
     * parameters.
     * 
     * @param existingStation
     * @param passengerType
     */
    public void checkTheTypeOfPasseneger(Station existingStation, String passengerType) {
        switch (passengerType) {
            case MetroCardSystemConstants.ADULT:
                existingStation.setNoOfAdultTravelled(existingStation.getNoOfAdultTravelled() + 1);
                break;
            case MetroCardSystemConstants.KID:
                existingStation.setNoOfKidTravelled(existingStation.getNoOfKidTravelled() + 1);
                break;
            case MetroCardSystemConstants.SENIOR_CITIZEN:
                existingStation.setNoOfKidTravelled(existingStation.getNoOfKidTravelled() + 1);
                break;
            default:
                break;
        }
    }

}

