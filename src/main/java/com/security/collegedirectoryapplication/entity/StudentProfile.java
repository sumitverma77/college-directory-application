package com.security.collegedirectoryapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_profile")
@Data
public class StudentProfile {
    @Id
    private Long userId;
    /*
 id is acting like a foreign key which is taking the reference from the primary key of User Table
     */

    @Column(length = 255)
    private String photo;
    private Long departmentId;
    private String year;

}
