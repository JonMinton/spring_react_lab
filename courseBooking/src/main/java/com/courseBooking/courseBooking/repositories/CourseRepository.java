package com.courseBooking.courseBooking.repositories;

import com.courseBooking.courseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

//    Get all courses with a given rating
    List<Course> findByStarRating(int starRating);

    List<Course> findByBookingsCustomerName(String customerName);

}
