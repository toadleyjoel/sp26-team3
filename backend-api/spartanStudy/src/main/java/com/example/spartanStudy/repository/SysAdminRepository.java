package com.example.spartanStudy.repository;

import com.example.spartanStudy.entity.SysAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAdminRepository extends JpaRepository<SysAdmin, Long> {
    SysAdmin findByEmail(String email);
}