package com.security.collegedirectoryapplication.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonalInfoResponse {
    private String name;
    private String photo;
    private String email;
    private String phone;
}
