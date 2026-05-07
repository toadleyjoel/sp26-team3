package com.example.spartanStudy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public String viewReviews(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviews-list";
    }

    @GetMapping("/new")
    public String showReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "review-form";
    }

    @PostMapping("/save")
    public String saveReview(@ModelAttribute Review review, Model model) {
        reviewRepository.save(review);
        model.addAttribute("review", review);
        return "review-success";
    }
}