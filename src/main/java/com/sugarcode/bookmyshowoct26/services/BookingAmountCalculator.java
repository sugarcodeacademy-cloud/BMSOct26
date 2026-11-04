package com.sugarcode.bookmyshowoct26.services;

import com.sugarcode.bookmyshowoct26.models.Show;
import com.sugarcode.bookmyshowoct26.models.ShowSeat;
import com.sugarcode.bookmyshowoct26.models.ShowSeatType;
import com.sugarcode.bookmyshowoct26.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingAmountCalculator {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public BookingAmountCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculateBookingAmount(Show show, List<ShowSeat> showSeats) {
        double bookingAmount = 0.0;

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

//        for (ShowSeatType showSeatType : showSeatTypes) {
//            if(showSeats.get(0).getSeat().getSeatType().equals(showSeatType.getSeatType())) {
//                bookingAmount += showSeats.size()*showSeatType.getPrice();
//            }
//        }
//        return bookingAmount;
        for(ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    bookingAmount +=  showSeatType.getPrice();
                }
            }
        }
        return bookingAmount;
    }
}

/*
PVR Gachibowli
Avatar --> 3d, gold --> 350, silver --> 250

A1, A2, A3,(Gold) L1, L2, L3(Silver)
Ranabali --> 2d silver --> 200
Bahubali --> 2d, gold --> 450, silver --> 350
 */
