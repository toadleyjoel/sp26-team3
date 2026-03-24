package com.example.spartanStudy.service;

import com.example.spartanStudy.entity.Session;
import com.example.spartanStudy.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findById(id);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public List<Session> getSessionsByStudentId(Long studentId) {
        return sessionRepository.findByStudentId(studentId);
    }


    public List<Session> getSessionsBySubject(String subject) {
        return sessionRepository.findBySubject(subject);
    }

    public Session updateSession(Long id, Session sessionDetails) {
        return sessionRepository.findById(id).map(session -> {
            session.setSubject(sessionDetails.getSubject());
            session.setStartDate(sessionDetails.getStartDate());
            session.setEndDate(sessionDetails.getEndDate());
            return sessionRepository.save(session);
        }).orElseThrow(() -> new RuntimeException("Session not found"));
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}