package com.example.spartanStudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentViewController {

    @Autowired
    private StudentService studentService;

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Show all tutoring services
    @GetMapping("/services/view")
    public String showServices(Model model) {
        model.addAttribute("services", studentService.getAllServices());
        return "service-list";
    }

    // Show subscribe form
    @GetMapping("/web/students/{studentId}/subscribe/{serviceId}")    
    public String showSubscribePage(@PathVariable Long studentId,
                                    @PathVariable Long serviceId,
                                    Model model) {
        model.addAttribute("studentId", studentId);
        model.addAttribute("serviceId", serviceId);
        return "subscribe-form";
    }

    // Process subscribe action
    @PostMapping("/web/students/{studentId}/subscribe/{serviceId}")    
    public String subscribeToService(@PathVariable Long studentId,
                                     @PathVariable Long serviceId,
                                     Model model) {
        Subscription subscription = studentService.subscribe(studentId, serviceId);
        model.addAttribute("subscription", subscription);
        return "subscribe-success";
    }
}