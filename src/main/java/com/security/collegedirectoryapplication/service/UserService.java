package com.security.collegedirectoryapplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.collegedirectoryapplication.constants.MessageConstants;
import com.security.collegedirectoryapplication.entity.AdministratorProfile;
import com.security.collegedirectoryapplication.entity.FacultyProfile;
import com.security.collegedirectoryapplication.entity.StudentProfile;
import com.security.collegedirectoryapplication.entity.User;
import com.security.collegedirectoryapplication.enums.Role;
import com.security.collegedirectoryapplication.repo.AdministratorProfileRepo;
import com.security.collegedirectoryapplication.repo.FacultyProfileRepo;
import com.security.collegedirectoryapplication.repo.StudentProfileRepo;
import com.security.collegedirectoryapplication.repo.UserRepo;
import com.security.collegedirectoryapplication.request.LoginRequest;
import com.security.collegedirectoryapplication.request.PersonalInfoRequest;
import com.security.collegedirectoryapplication.response.LoginResponse;
import com.security.collegedirectoryapplication.response.PersonalInfoResponse;
import com.security.collegedirectoryapplication.response.ResponseWrapper;
import jakarta.validation.Valid;
import jdk.jshell.Snippet;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private StudentProfileRepo studentProfileRepo;
    @Autowired
    private FacultyProfileRepo facultyProfileRepo;
    @Autowired
    private AdministratorProfileRepo administratorProfileRepo;


    public LoginResponse AuthenticateUser(@Valid LoginRequest loginRequest)
    {
            User user   = userRepo.findByUsername(loginRequest.getUsername());
       if (user != null
               && Objects.equals(user.getPassword(), loginRequest.getPassword())
               && Objects.equals(user.getUsername() , loginRequest.getUsername())
               && Objects.equals(user.getRole(), Role.valueOf(loginRequest.getRole().toUpperCase())))
       {
           return new LoginResponse(user.getName(), user.getRole().toString() , MessageConstants.LOGIN_SUCCESSFUL);
       }
       else {
           return new LoginResponse(null , null , MessageConstants.INVALID_CREDENTIALS);
       }
    }

    public ResponseWrapper<PersonalInfoResponse> getPersonalInfo(@Valid PersonalInfoRequest personalInfoRequest) {
        User user = userRepo.findByUsername(personalInfoRequest.getUserName());

        if (Objects.isNull(user)) {
            return new ResponseWrapper<>(null, MessageConstants.INVALID_USERNAME, HttpStatus.NOT_FOUND);
        }

        PersonalInfoResponse personalInfoResponse = new PersonalInfoResponse(
                user.getName(),
                null,
                user.getEmail(),
                user.getPhone()
        );

        long userId = userRepo.findById(user.getUserId()).get().getUserId();

        if (user.getRole().equals(Role.STUDENT)) {
            StudentProfile student = studentProfileRepo.findByUserId(userId);
            personalInfoResponse.setPhoto(Objects.nonNull(student) ? student.getPhoto() : null);
        } else if (user.getRole().equals(Role.FACULTY)) {
            FacultyProfile faculty = facultyProfileRepo.findByUserId(userId);
            personalInfoResponse.setPhoto(Objects.nonNull(faculty) ? faculty.getPhoto() : null);
        } else if (user.getRole().equals(Role.ADMINISTRATOR)) {
            AdministratorProfile admin = administratorProfileRepo.findByUserId(userId);
            personalInfoResponse.setPhoto(Objects.nonNull(admin) ? admin.getPhoto() : null);
        }

        return new ResponseWrapper<>(personalInfoResponse, null, HttpStatus.OK);
    }


}
