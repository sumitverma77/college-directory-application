package com.security.collegedirectoryapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "administrator_profile")
@Data
public class AdministratorProfile {
    @Id
    private long userId;
    /*
   here also id is acting like a foreign key which is taking the reference from the primary key of User Table
    */
    @Column(length = 255)
    private String photo;
    private Long departmentId;
}