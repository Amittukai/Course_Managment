package com.course.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.management.controllers.base.BaseController;
import com.course.management.dtos.CourseDto;
import com.course.management.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    CourseService courseService;

    @GetMapping()
    public ResponseEntity getAllCourse(){
        return sendSuccessApiResponse(courseService.getAllCourse());
    }

    @GetMapping("{courseCode}/module")
    public ResponseEntity getAllModuleOfACourse(@PathVariable String courseCode){
        return sendSuccessApiResponse(courseService.getAllModuleByCourse(courseCode));
    }

    @PostMapping()
    public ResponseEntity addCourse(@RequestBody CourseDto courseDto){
        return sendSuccessApiResponse(courseService.addCourse(courseDto));
    }

    @DeleteMapping
    public ResponseEntity deleteCourse(@RequestParam String code) {			//The @RequestParam is used to read the HTML form data 
    																		//provided by a user and bind it to the request parameter.
        return sendSuccessApiResponse(courseService.deleteCourse(code));
    }

}
