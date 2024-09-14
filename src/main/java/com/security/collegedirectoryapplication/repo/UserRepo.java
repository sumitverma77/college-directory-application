package com.security.collegedirectoryapplication.repo;

import com.security.collegedirectoryapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
   public User findByUsername(String username);
   public User findByUserId(Long userId);
}
