package com.sugarcode.bookmyshowoct26.repositories;

import com.sugarcode.bookmyshowoct26.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //select * from users where email = ""
    Optional<User> findByEmail(String email);
}
