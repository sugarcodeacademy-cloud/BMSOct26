package com.sugarcode.bookmyshowoct26.controllers;

import com.sugarcode.bookmyshowoct26.dtos.SignUpResponseDto;
import com.sugarcode.bookmyshowoct26.dtos.SignUpRequestDto;
import com.sugarcode.bookmyshowoct26.models.User;
import com.sugarcode.bookmyshowoct26.services.UserService;
import org.springframework.stereotype.Controller;
import com.sugarcode.bookmyshowoct26.dtos.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto requestDto){
        //TODO: Handle the exceptions
        User user = userService.signUp(requestDto.name(), requestDto.email(), requestDto.password());

        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        signUpResponseDto.setUserId(user.getId());
        signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        return signUpResponseDto;
    }

        //TODO: Implement the login functionality
        //TODO: Use .matches to check the password
}
