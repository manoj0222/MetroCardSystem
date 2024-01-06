package com.example.geektrust.Utils;

import java.util.Comparator;

import com.example.geektrust.Dto.PrintSummaryDto;

public class PassengerSummarySort implements Comparator<PrintSummaryDto> {

    @Override
    public int compare(PrintSummaryDto pd1, PrintSummaryDto pd2) {
        if (pd1.getCount() == pd2.getCount()) {
            // If any of the passenger type have same value for passenger count then display in the
            // ascending order of the passenger type for that case.
            return pd1.getPassenegerType().compareTo(pd2.getPassenegerType());
        } else if (pd1.getCount() < pd2.getCount()) {
            return 1;
        } else {
            return -1;
        }
    }

}

