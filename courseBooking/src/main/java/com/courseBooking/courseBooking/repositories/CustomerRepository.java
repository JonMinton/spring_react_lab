package com.courseBooking.courseBooking.repositories;

import com.courseBooking.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Get all customers for a given course
    List<Customer> findAllByBookingsCourseName(String courseName);

}
