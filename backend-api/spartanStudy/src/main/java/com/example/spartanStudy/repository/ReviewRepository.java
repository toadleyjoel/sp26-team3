package com.example.spartanStudy.repository;

import com.example.spartanStudy.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
  @Query(value = "SELECT r.* FROM reviews r WHERE r.student_id = :studentId", nativeQuery = true)
  List<Review> findByStudentId(Long studentId);

  @Query(value = "SELECT r.* FROM reviews r WHERE r.session_id = :sessionId", nativeQuery = true)
  List<Review> findBySessionId(Long sessionId);

}