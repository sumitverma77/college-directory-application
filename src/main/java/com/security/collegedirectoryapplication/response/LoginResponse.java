package com.security.collegedirectoryapplication.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
    String name;
    String Role;
    String message;
}
