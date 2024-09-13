package com.security.collegedirectoryapplication.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enrollment")
@Data
public class Enrollment {
    @Id
    private Long id;
    private Long studentId;
    private Long courseId;
}