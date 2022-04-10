package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Course;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    //courses/2
    @GetMapping("/courses/{cid}")
    public Course singleCourse(@PathVariable("cid") Integer courseId) {

        Course singleCourse= allcourse.stream()
                             .filter(course->courseId.equals(course.getCourseId()))
                             .findAny()
                             .orElse(new Course(404,"not found ","Not found"));

        return singleCourse;
    }

     //courses/2
    @PutMapping("/courses/{cid}")
    public List<Course> updateCourse(@PathVariable("cid") Integer courseId,@RequestBody Course updatedCourse) {

        Course singleCourse= allcourse.stream()
                             .filter(course->courseId.equals(course.getCourseId()))
                             .findAny()
                             .orElse(new Course(404,"not found ","Not found"));


        allcourse.set(allcourse.indexOf(singleCourse), updatedCourse);
        return allcourse;
    }
    
    //courses/2
    @DeleteMapping("/courses/{cid}")
    public List<Course> deleteCourse(@PathVariable("cid") Integer courseId) {
        allcourse.removeIf(course->course.getCourseId().equals(courseId));
        return allcourse;
    }





 

    
}
