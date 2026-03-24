package com.example.spartanStudy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dev_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long logId;

  @ManyToOne
  @JoinColumn(name = "admin_id", nullable = false)
  @JsonIgnoreProperties("devLogs")
  private SysAdmin admin;

  @Column(nullable = false)
  private String action;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EntityType entityType;

  @Column(nullable = false)
  private Long entityId;

 @Column(columnDefinition = "TEXT")
  private String details;

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}

enum EntityType {
  USER,
  SESSION,
  REVIEW,
  OTHER
}