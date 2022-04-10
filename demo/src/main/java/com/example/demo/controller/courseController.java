package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class courseController {

    private List<Course> allcourse= new ArrayList<>();
    

    public courseController() {
        allcourse.add(new Course(1,"React.js","Gourab Banik"));
        allcourse.add(new Course(2,"Angular.js","Anju Bhuiya"));
        allcourse.add(new Course(3,"Spring Boot","Tiyasha Dey"));
    }


    @GetMapping("/courses")
    public List<Course> allCourse() {
        return allcourse;
    }


    @PostMapping("/postcourse")
    public List<Course> postCourse(@RequestBody Course course) {
        allcourse.add(course);
        return allcourse;
    }

    
}
