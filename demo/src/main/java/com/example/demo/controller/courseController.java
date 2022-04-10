package com.example.demo.controller;

import java.util.List;

import com.example.demo.models.Course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class courseController {
    

    @GetMapping("/courses")
    public Course allCourse() {
        return new Course(1, "React.js", "Gourab");
        
    }
    
}
