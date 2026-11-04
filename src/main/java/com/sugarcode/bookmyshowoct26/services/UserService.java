package com.sugarcode.bookmyshowoct26.services;

import com.sugarcode.bookmyshowoct26.models.User;
import com.sugarcode.bookmyshowoct26.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String name, String email, String password) {
        /*
        1.check if the user is already present with same email id
        2.if yes, ask the user to login
        3.if no, create a new user and save it to the DB
         */
        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isPresent()) {
            //throw exception
            //User already exists, please try to login
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }
}
