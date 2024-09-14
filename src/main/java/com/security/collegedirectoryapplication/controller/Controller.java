package com.security.collegedirectoryapplication.controller;

import com.security.collegedirectoryapplication.request.LoginRequest;
import com.security.collegedirectoryapplication.request.PersonalInfoRequest;
import com.security.collegedirectoryapplication.response.LoginResponse;
import com.security.collegedirectoryapplication.response.PersonalInfoResponse;
import com.security.collegedirectoryapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return userService.AuthenticateUser(loginRequest);
    }

    @GetMapping("/user/personal/info")
    public Object userPersonalInfo(@RequestBody PersonalInfoRequest personalInfoRequest)
    {
        return userService.getPersonalInfo(personalInfoRequest);
    }


}
