package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Course;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class CourseServices {

    private List<Course> allcourse= new ArrayList<>();

    public CourseServices() {
        allcourse.add(new Course(1,"React.js","Gourab Banik"));
        allcourse.add(new Course(2,"Angular.js","Anju Bhuiya"));
        allcourse.add(new Course(3,"Spring Boot","Tiyasha Dey"));
    }


    public List<Course> allCourse() {
        return allcourse;
    }

    public List<Course> postCourse(@RequestBody Course course) {
        allcourse.add(course);
        return allcourse;
    }

    public Course singleCourse(@PathVariable("cid") Integer courseId) {

        Course singleCourse= allcourse.stream()
                             .filter(course->courseId.equals(course.getCourseId()))
                             .findAny()
                             .orElse(new Course(404,"not found ","Not found"));

        return singleCourse;
    }

    public List<Course> updateCourse(@PathVariable("cid") Integer courseId,@RequestBody Course updatedCourse) {

        Course singleCourse= allcourse.stream()
                             .filter(course->courseId.equals(course.getCourseId()))
                             .findAny()
                             .orElse(new Course(404,"not found ","Not found"));


        allcourse.set(allcourse.indexOf(singleCourse), updatedCourse);
        return allcourse;
    }


    public List<Course> deleteCourse(@PathVariable("cid") Integer courseId) {
        allcourse.removeIf(course->course.getCourseId().equals(courseId));
        return allcourse;
    }


}
