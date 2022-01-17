package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.service.CouserService;
import com.springrest.springrest.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CouserService couserService;

    @GetMapping("/home")
    public String home(){ return "this is home page"; }

    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return this.couserService.getCourses();
    }

    @GetMapping("courses/{courseId}")
    public Courses getCourse(@PathVariable String courseId){
        return this.couserService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("courses")
    public Courses addCourse(@RequestBody Courses courses){
        return this.couserService.addCourse(courses);
    }

    @PutMapping("/courses")
    public Courses updateCourse(@RequestBody Courses courses){
        return this.couserService.updateCourse(courses);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.couserService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
