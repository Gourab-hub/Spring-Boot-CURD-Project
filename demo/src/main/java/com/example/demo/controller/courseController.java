package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.Course;
import com.example.demo.services.CourseServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api")
public class courseController {

    @Autowired
    private CourseServices courseServices;

    @GetMapping("/courses")
    public List<Course> allCourse() {
        return courseServices.allCourse();
    }

    @PostMapping("/postcourse")
    public List<Course> postCourse(@RequestBody Course course) throws Exception {

        try {
            return courseServices.postCourse(course);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,e.getMessage());
        }

        
    }

    // courses/2
    @GetMapping("/courses/{cid}")
    public Optional<Course> singleCourse(@PathVariable("cid") Integer courseId) throws Exception {

        try {
            return courseServices.singleCourse(courseId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        
    }

    // courses/2
    @PutMapping("/courses/{cid}")
    public List<Course> updateCourse(@PathVariable("cid") Integer courseId, @RequestBody Course updatedCourse) {

        return courseServices.updateCourse(courseId, updatedCourse);
    }

    // courses/2
    @DeleteMapping("/courses/{cid}")
    public List<Course> deleteCourse(@PathVariable("cid") Integer courseId) {
        return courseServices.deleteCourse(courseId);
    }

}
