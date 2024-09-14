package com.security.collegedirectoryapplication.repo;

import com.security.collegedirectoryapplication.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
//    public Course findById(long id);
}
