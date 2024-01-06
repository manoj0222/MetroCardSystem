package com.example.geektrust.Utils;

public class PassengerServiceImplUtil {

    /**
     * The Behaviour of the below mentioned function is based on the passengerType we return travelCharge.
     * @param passengerType
     * @return travelCharge
     */

    public Double checkPassengerType(String passengerType) {
        Double travelCharge = 0.0;
        switch (passengerType) {
            case MetroCardSystemConstants.SENIOR_CITIZEN:
                travelCharge = 100.0;
                break;
            case MetroCardSystemConstants.ADULT:
                travelCharge = 200.0;
                break;
            case MetroCardSystemConstants.KID:
                travelCharge = 50.0;
                break;
            default:
                travelCharge = 0.0;
                break;
        }
        return travelCharge;
    }

}

