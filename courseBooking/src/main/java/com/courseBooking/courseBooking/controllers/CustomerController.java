package com.courseBooking.courseBooking.controllers;

import com.courseBooking.courseBooking.models.Customer;
import com.courseBooking.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(name="courseName", required = false) String courseName) {
        if(courseName != null) {
            return new ResponseEntity<>(customerRepository.findAllByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
