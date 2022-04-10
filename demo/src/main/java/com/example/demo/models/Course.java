package com.example.demo.models;

public class Course {
    private Integer courseId;
    private String courseName;
    private String courseInstrucror;
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseInstrucror() {
        return courseInstrucror;
    }
    public void setCourseInstrucror(String courseInstrucror) {
        this.courseInstrucror = courseInstrucror;
    }
    public Course(Integer courseId, String courseName, String courseInstrucror) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInstrucror = courseInstrucror;
    }
    public Course() {
    }
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseInstrucror=" + courseInstrucror + ", courseName=" + courseName
                + "]";
    }
    

    
}
