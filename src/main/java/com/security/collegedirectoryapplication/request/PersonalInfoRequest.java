package com.security.collegedirectoryapplication.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonalInfoRequest {
    @NotEmpty
    private String userName;
}
