package com.sugarcode.bookmyshowoct26.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Long bookingId;
    private BookingResponseStatus responseStatus;
}
