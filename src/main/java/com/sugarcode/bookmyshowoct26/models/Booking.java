package com.sugarcode.bookmyshowoct26.models;

import com.sugarcode.bookmyshowoct26.models.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel {
    private String bookingNumber;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ManyToMany
    private List<ShowSeat> showSeats;
    private Date time;

    @OneToMany
    private List<Payment> payments;
    private double amount;

    /*
        1       1
    Booking -- User --> M: 1
        M       1

         1         1
    Booking --- Show --> M : 1
         M        1

         1          M
     Booking --- ShowSeat -> M : M
        M            1

     Booking1 -> S1 A1
     Booking1 -> S1 A2

     Booking1 -> S1 A1 -> CANCELLED
     Booking2 -> S1 A1 -> BOOKED

        1          M
     Booking --- Payment --> 1:M
       1            1

     Booking1 -> ABC123
     Booking1 -> ABC123
     Booking1 -> AXIS123



     */

}
