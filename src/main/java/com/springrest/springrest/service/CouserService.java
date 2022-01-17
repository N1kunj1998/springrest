package com.springrest.springrest.service;

import com.springrest.springrest.entities.Courses;

import java.util.List;

public interface CouserService {
    public List<Courses> getCourses();
    public Courses getCourse(Long courseId);
    public Courses addCourse(Courses courses);
    Courses updateCourse(Courses courses);
    void deleteCourse(long parseLong);
}
