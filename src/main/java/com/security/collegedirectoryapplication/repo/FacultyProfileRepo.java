package com.security.collegedirectoryapplication.repo;

import com.security.collegedirectoryapplication.entity.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyProfileRepo extends JpaRepository<FacultyProfile, Long> {
    public FacultyProfile findByUserId(long id);
}
