package com.courseBooking.courseBooking.controllers;

import com.courseBooking.courseBooking.models.Course;
import com.courseBooking.courseBooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourses(
            @RequestParam(name="rating", required = false) Integer rating,
            @RequestParam(name="customerName", required = false) String customerName
    ) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByStarRating(rating), HttpStatus.OK);
        }
        if (customerName != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(customerName), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
