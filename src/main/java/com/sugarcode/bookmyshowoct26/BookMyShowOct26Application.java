package com.sugarcode.bookmyshowoct26;

import com.sugarcode.bookmyshowoct26.controllers.BookingController;
import com.sugarcode.bookmyshowoct26.models.BaseModel;
import com.sugarcode.bookmyshowoct26.models.Booking;
import com.sugarcode.bookmyshowoct26.models.Theatre;
import com.sugarcode.bookmyshowoct26.services.BookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowOct26Application {

    public static void main(String[] args) {

        SpringApplication.run(BookMyShowOct26Application.class, args);
        System.out.println("Spring Boot Application Started");


    }

}
