package com.sugarcode.bookmyshowoct26.controllers;

import com.sugarcode.bookmyshowoct26.dtos.BookingResponseStatus;
import com.sugarcode.bookmyshowoct26.dtos.CreateBookingRequestDto;
import com.sugarcode.bookmyshowoct26.dtos.CreateBookingResponseDto;
import com.sugarcode.bookmyshowoct26.models.Booking;
import com.sugarcode.bookmyshowoct26.services.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public CreateBookingResponseDto createBooking(CreateBookingRequestDto requestDto) {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();
        try {
            Booking booking = bookingService.createBooking(requestDto.getUserId(), requestDto.getShowId(), requestDto.getShowSeatIds());
            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(BookingResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            responseDto.setResponseStatus(BookingResponseStatus.FAILURE);
        }
        return responseDto;
    }


}

//
//    @GetMapping("/movies")
//    public List<Movie> getAllMovies(){
//        return bookingService.findAllMovies();
//    }

//IoC --> Beans(objects created by Spring) -- handles all the beans and dependency inversions