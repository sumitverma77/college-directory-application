package com.security.collegedirectoryapplication.repo;

import com.security.collegedirectoryapplication.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
//    public Department findById(long id);
}
