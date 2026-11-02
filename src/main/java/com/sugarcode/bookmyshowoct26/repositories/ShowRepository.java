package com.sugarcode.bookmyshowoct26.repositories;

import com.sugarcode.bookmyshowoct26.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
