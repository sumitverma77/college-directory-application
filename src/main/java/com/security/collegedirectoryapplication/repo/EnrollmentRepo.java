package com.security.collegedirectoryapplication.repo;

import com.security.collegedirectoryapplication.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    public List<Enrollment> findByStudentId(Long enrollmentId);
}
