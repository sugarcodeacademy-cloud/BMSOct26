package com.sugarcode.bookmyshowoct26.dtos;

import lombok.Getter;
import lombok.Setter;
import com.sugarcode.bookmyshowoct26.dtos.ResponseStatus;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Long bookingId;
    private ResponseStatus responseStatus;
}
