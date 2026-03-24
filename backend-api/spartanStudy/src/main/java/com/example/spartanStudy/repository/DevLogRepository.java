package com.example.spartanStudy.repository;

import com.example.spartanStudy.entity.DevLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevLogRepository extends JpaRepository<DevLog, Long> {
   @Query(value = "SELECT a.* FROM devlogs a WHERE a.admin_id = :adminId", nativeQuery = true)
    List<DevLog> findByAdminId(Long adminId);
    List<DevLog> findByEntityType(String entityType);
}