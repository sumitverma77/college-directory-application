package com.security.collegedirectoryapplication.repo;

import com.security.collegedirectoryapplication.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepo extends JpaRepository<StudentProfile, Long> {
    public StudentProfile findByUsername(String user);
}
