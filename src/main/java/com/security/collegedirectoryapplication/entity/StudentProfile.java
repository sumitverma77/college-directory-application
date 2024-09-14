package com.security.collegedirectoryapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_profile")
@Data
public class StudentProfile {
    @Id
    private String username;

    @Column(length = 255)
    private String photo;
    private Long departmentId;
    private String year;

}
