package com.example.spartanStudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private ServiceRepository serviceRepo;

    @Autowired
    private SubscriptionRepository subscriptionRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    // 1. Create Customer
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    // 2. Update Customer
    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setMajor(updatedStudent.getMajor());

        return studentRepo.save(student);
    }

    // 3. View Services
    public List<ServiceEntity> getAllServices() {
        return serviceRepo.findAll();
    }

    // 4. Subscribe
    public Subscription subscribe(Long studentId, Long serviceId) {
        Subscription sub = new Subscription();
        sub.setStudentId(studentId);
        sub.setServiceId(serviceId);
        return subscriptionRepo.save(sub);
    }

    // 5. Write Review
    public Review addReview(Review review) {
        return reviewRepo.save(review);
    }
}