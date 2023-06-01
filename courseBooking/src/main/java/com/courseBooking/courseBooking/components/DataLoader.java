package com.courseBooking.courseBooking.components;

import com.courseBooking.courseBooking.repositories.BookingRepository;
import com.courseBooking.courseBooking.repositories.CourseRepository;
import com.courseBooking.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;


}
