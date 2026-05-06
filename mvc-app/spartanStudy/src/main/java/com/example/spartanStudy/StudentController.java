package com.example.spartanStudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // 1. Create Customer
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // 2. Update Customer
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // 3. View Services
    @GetMapping("/services")
    public List<ServiceEntity> getServices() {
        return service.getAllServices();
    }

    // 4. Subscribe
    @PostMapping("/{studentId}/subscribe/{serviceId}")
    public Subscription subscribe(@PathVariable Long studentId,
                                  @PathVariable Long serviceId) {
        return service.subscribe(studentId, serviceId);
    }

    // 5. Review
    @PostMapping("/review")
    public Review addReview(@RequestBody Review review) {
        return service.addReview(review);
    }
}