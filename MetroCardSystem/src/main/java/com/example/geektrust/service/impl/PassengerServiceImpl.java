package com.example.geektrust.service.impl;

import com.example.geektrust.Utils.PassengerServiceImplUtil;
import com.example.geektrust.entity.MetroCard;
import com.example.geektrust.entity.Passenger;
import com.example.geektrust.repository.IPassengerRepository;
import com.example.geektrust.service.IMetroCard;
import com.example.geektrust.service.IPassenger;
import com.example.geektrust.service.IStation;

public class PassengerServiceImpl implements IPassenger {

	  private IPassengerRepository passengerRepository;
	  private PassengerServiceImplUtil passengerServiceUtil;
	  private Double travelCharges = 0.0;
	  private Double cardBalance = 0.0;


	  public PassengerServiceImpl(IPassengerRepository passengerRepository) {
	    this.passengerRepository = passengerRepository;
	    this.passengerServiceUtil = new PassengerServiceImplUtil();
	  }

	  @Override
	  public void checkIn(String cardNumber, String passengerType, String fromStation,
	      IStation stationServcie, IMetroCard metroCardService) {

	    if (cardNumber == null || passengerType == null || fromStation == null || stationServcie == null
	        || metroCardService == null) {
	      System.out.println("InValid Command");
	    } else {
	      // First we will check whether the metroCard is Valid or not.
	      MetroCard metroCard = checkCardNumberIsValidOrNot(cardNumber, metroCardService);
	      // getCharges BAsed on the passenger Type.
	      travelCharges = this.passengerServiceUtil.checkPassengerType(passengerType);
	      // Based on the metroCard get the Passenger Data if already existed means.
	      Passenger passenger = this.passengerRepository.findPassengerByCardNumber(cardNumber);
	      // Check whether the it passengerFirstRide or ReturnRide inorder to Apply discount.
	      Double discountAmount =
	          checkForFirstRideOrReturnRide(passenger, this.passengerRepository, passengerType);
	      // Compare for travelChargeAmount and availablebalance for AutoRecharge.
	      Double shortAgeAmount = checkForAutoRechargeAmount(travelCharges, metroCard);
	      // Deducted amount from the metroCard with including serviceTax
	      cardBalance = finalBalanceAfterDeductions(shortAgeAmount, discountAmount, metroCard);
	      // update the balance in MetroCard.
	      metroCard.setBalance(cardBalance);
	      // update the Passenger
	      this.passengerRepository.update(metroCard, passengerType);
	      // update the station entity also.
	      stationServcie.updateStation(fromStation, discountAmount, travelCharges, shortAgeAmount,
	          passengerType);
	    }

	  }

	  /**
	   * 
	   * @param shortAgeAmount
	   * @param discountAmount
	   * @param metroCard
	   * @return
	   */
	  private Double finalBalanceAfterDeductions(Double shortAgeAmount, Double discountAmount,
	      MetroCard metroCard) {
	    if (metroCard != null) {
	      Double cardBalance = metroCard.getBalance();
	      cardBalance = cardBalance - shortAgeAmount + discountAmount;
	      return cardBalance;
	    }
	    return 0.0;
	  }

	  /**
	   * function returns the shortageAmount which can be used during the autorecharging behaviour
	   * 
	   * @param travelCharges2
	   * @param metroCard
	   * @return
	   */
	  private Double checkForAutoRechargeAmount(Double travelCharges2, MetroCard metroCard) {
	    // If the Balance present in the metrCardIs < travelCharges.
	    if (metroCard != null && metroCard.getBalance() < travelCharges2) {
	      Double shortageAmount = travelCharges2 - metroCard.getBalance();
	      return shortageAmount;
	    } else {
	      return 0.0;
	    }
	  }

	  /**
	   * 
	   * @param passenger
	   * @param passengerRepository
	   * @param passengerType
	   * @return
	   */
	  private Double checkForFirstRideOrReturnRide(Passenger passenger,
	      IPassengerRepository passengerRepository, String passengerType) {
	    Double discountAmount = 0.0;
	    if (passenger != null && (passenger.getNoOfJourneyTravelled() > 0
	        && passenger.getNoOfJourneyTravelled() % 2 == 0)) {
	      Double normalTravelCharge = this.passengerServiceUtil.checkPassengerType(passengerType);
	      discountAmount = normalTravelCharge * 0.05;
	    }
	    return discountAmount;
	  }

	  /**
	   * 
	   * @param cardNumber
	   * @param metroCardService
	   * @return
	   */
	  private MetroCard checkCardNumberIsValidOrNot(String cardNumber, IMetroCard metroCardService) {
	    return metroCardService.findCardByNumber(cardNumber);
	  }

	}

