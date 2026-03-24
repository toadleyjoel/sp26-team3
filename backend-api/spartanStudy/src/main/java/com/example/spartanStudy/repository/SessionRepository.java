package com.example.spartanStudy.repository;

import com.example.spartanStudy.entity.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
  @Query(value = "SELECT s.* FROM sessions s WHERE s.student_id = :studentId", nativeQuery = true)
    List<Session> findByStudentId(Long studentId);

  @Query(value = "SELECT s.* FROM sessions s WHERE s.subject = :subject", nativeQuery = true)
    List<Session> findBySubject(String subject);
}