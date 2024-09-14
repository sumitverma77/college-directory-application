package com.security.collegedirectoryapplication.repo;

import com.security.collegedirectoryapplication.entity.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorProfileRepo extends JpaRepository<AdministratorProfile, Long> {
    public AdministratorProfile findByUsername(String username);
}
