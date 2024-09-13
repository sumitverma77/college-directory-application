package com.security.collegedirectoryapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "faculty_profile")
@Data
public class FacultyProfile {
    @Id
    private Long userId;

    @Column(length = 255)
    private String photo;
    private Long departmentId;

    @Column(length= 255)
    private String officeHours;
}
