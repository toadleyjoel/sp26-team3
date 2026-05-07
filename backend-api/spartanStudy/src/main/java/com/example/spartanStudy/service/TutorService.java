package com.example.spartanStudy.service;

import com.example.spartanStudy.entity.Tutor;
import com.example.spartanStudy.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Optional<Tutor> getTutorById(Long id) {
        return tutorRepository.findById(id);
    }

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Tutor updateTutor(Long id, Tutor tutorDetails) {
        return tutorRepository.findById(id).map(tutor -> {
            if (tutorDetails.getEmail() != null) {
                tutor.setEmail(tutorDetails.getEmail());
            }
            if (tutorDetails.getSubject() != null) {
                tutor.setSubject(tutorDetails.getSubject());
            }
            if (tutorDetails.getStatus() != null) {
                tutor.setStatus(tutorDetails.getStatus());
            }
            return tutorRepository.save(tutor);
        }).orElseThrow(() -> new RuntimeException("Tutor not found"));
    }

    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }

    public Tutor getTutorByEmail(String email) {
        return tutorRepository.findByEmail(email);
    }
}