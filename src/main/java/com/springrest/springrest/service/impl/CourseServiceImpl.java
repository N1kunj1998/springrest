package com.springrest.springrest.service.impl;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.service.CouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CouserService {

    @Autowired
    private CourseDao courseDao;

//    List<Courses> coursesList;

    public CourseServiceImpl() {
//        coursesList = new ArrayList<Courses>();
//        coursesList.add(new Courses(145L, "Java Core Course", "this course contains basics of java"));
//        coursesList.add(new Courses(4343L, "Spring Boot Course", "creating rest api using spring boot"));
    }

    @Override
    public List<Courses> getCourses() {
//        return coursesList;
        return courseDao.findAll();
    }

    public Courses getCourse(Long courseId){
//        for(Courses courses : coursesList){
//            if(courses.getId().equals(courseId)) {
//                return courses;
//            }
//        }
        return courseDao.getById(courseId);
    }

    @Override
    public Courses addCourse(Courses courses) {
//        coursesList.add(courses);
        courseDao.save(courses);
        return courses;
    }

    @Override
    public Courses updateCourse(Courses courses) {
//        coursesList.forEach(e -> {
//            if(e.getId() == courses.getId()){
//                e.setTitle(courses.getTitle());
//                e.setDescription(courses.getDescription());
//            }
//        });
        return courseDao.save(courses);
    }

    @Override
    public void deleteCourse(long parseLong) {
//        coursesList = this.coursesList.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
//        courseDao.deleteById(parseLong);
        courseDao.delete(courseDao.getById(parseLong));
    }
}
