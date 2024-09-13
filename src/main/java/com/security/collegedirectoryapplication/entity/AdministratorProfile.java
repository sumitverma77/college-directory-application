package com.security.collegedirectoryapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "administrator_profile")
@Data
public class AdministratorProfile {
    @Id
    private Long userId;
    @Column(length = 255)
    private String photo;
    private Long departmentId;
}