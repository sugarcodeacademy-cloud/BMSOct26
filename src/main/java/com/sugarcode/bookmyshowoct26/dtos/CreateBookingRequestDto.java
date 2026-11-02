package com.sugarcode.bookmyshowoct26.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {
    private Long showId;
    private Long userId;
    private List<Long> showSeatIds;
}

//Special use case for dtos
//public record CreateBookingRequestDto(Long ShowId, Long userId, List<Long> showSeatIds){}
