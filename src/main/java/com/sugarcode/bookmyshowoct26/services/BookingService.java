package com.sugarcode.bookmyshowoct26.services;

import com.sugarcode.bookmyshowoct26.dtos.CreateBookingRequestDto;
import com.sugarcode.bookmyshowoct26.exceptions.SeatAlreadyBookedException;
import com.sugarcode.bookmyshowoct26.exceptions.ShowNotFoundException;
import com.sugarcode.bookmyshowoct26.exceptions.UserNotFoundException;
import com.sugarcode.bookmyshowoct26.models.*;
import com.sugarcode.bookmyshowoct26.models.enums.BookingStatus;
import com.sugarcode.bookmyshowoct26.models.enums.ShowSeatStatus;
import com.sugarcode.bookmyshowoct26.repositories.*;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;


    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository,
                          UserRepository userRepository, ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }
    @Transactional
    public Booking createBooking(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, SeatAlreadyBookedException {
        /*
        Steps:
        1.Fetch the user info from the database - Done
        2.Fetch the show details from the database - Done
        3.Fetch the show seats from the database - Done
        4.Check if all the seats are available - Done
        5.If all the seats are available, BLOCK all the seats - Done
        6.create a booking object
        7.Do the payment --> this will be handled by Payment service
        8.Save the booking and return the object back to client
         */

//        User user = userRepository.findById(userId).orElse(null);
//        if(user == null) {
//            return null;
//        }

          Optional<User> userOptional = userRepository.findById(userId);
          if(userOptional.isEmpty()) {
              //Throw an Exception user not found
              throw new UserNotFoundException("User with id: " + userId + "does not exist");
          }
          User user = userOptional.get();

          Optional<Show> showOptional = showRepository.findById(showId);
          if(showOptional.isEmpty()) {
              throw new ShowNotFoundException("Show with id: " + showId + "does not exist");
          }
          Show show = showOptional.get();

          //this locks the specfic rows only in database for write access only
          //other seats remain unlocked
          List<ShowSeat> showSeats = showSeatRepository.findAllByIdWithLock(showSeatIds);

          //check if all the seats are available
        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatAlreadyBookedException("Seat "+ showSeat.getSeat().getNumber() + " is not available");
            }
        }

        //block all the seats
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);//in memory
        }

        //update the status of the seats in the showSeat
        showSeatRepository.saveAll(showSeats);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        booking.setBookedAt(LocalDateTime.now());
        booking.setPayments(new ArrayList<>());

        booking = bookingRepository.save(booking);

        return booking;
    }
}

/*
 priya(orders, eats, pay) -->
 waiter(takes order, serve the dish) -->
 chef(needs ingredients, get ingredients from helper, prepare the dish, handover to waiter  )-->
 helper(list of ingredients)-->
 Pantry(Ingredients)


 user(request, receive the response) -->
 controller(takes request,send the response)--->
 service(data, get data from repositories,business logic, return the response)
 repository(get the list of data, receive the data) -->
 database(data)
 */

//    public List<Movie> findAllMovies(){
//       return movieRepository.findAll();
//    }
