package com.sugarcode.bookmyshowoct26.repositories;

import com.sugarcode.bookmyshowoct26.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
