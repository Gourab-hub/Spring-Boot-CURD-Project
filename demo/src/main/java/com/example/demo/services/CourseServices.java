package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.Course;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CourseServices {

    private List<Course> allcourse = new ArrayList<>();

    public CourseServices() {
        allcourse.add(new Course(1, "React.js", "Gourab Banik"));
        allcourse.add(new Course(2, "Angular.js", "Anju Bhuiya"));
        allcourse.add(new Course(3, "Spring Boot", "Tiyasha Dey"));
    }

    public List<Course> allCourse() {
        return allcourse;
    }

    public List<Course> postCourse(Course course) throws Exception {

        Optional<Course> singleCourse = allcourse.stream()
                .filter(c -> course.getCourseId().equals(c.getCourseId()))
                .findAny();

        if (singleCourse.isPresent()) {
            throw new Exception("Course with this ID alewady exist...");
        }

        allcourse.add(course);
        return allcourse;
    }

    public Optional<Course> singleCourse(Integer courseId) throws Exception {
        Optional<Course> singleCourse = allcourse.stream()
                .filter(course -> courseId.equals(course.getCourseId()))
                .findAny();

        if (!singleCourse.isPresent()) {
            throw new Exception("Course is not Present");
        }

        return singleCourse;
    }

    public List<Course> updateCourse(Integer courseId, @RequestBody Course updatedCourse) {

        Course singleCourse = allcourse.stream()
                .filter(course -> courseId.equals(course.getCourseId()))
                .findAny()
                .orElse(new Course(404, "not found ", "Not found"));

        allcourse.set(allcourse.indexOf(singleCourse), updatedCourse);
        return allcourse;
    }

    public List<Course> deleteCourse(Integer courseId) {
        allcourse.removeIf(course -> course.getCourseId().equals(courseId));
        return allcourse;
    }

}
