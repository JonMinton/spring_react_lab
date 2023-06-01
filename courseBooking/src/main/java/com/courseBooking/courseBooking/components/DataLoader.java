package com.courseBooking.courseBooking.components;

import com.courseBooking.courseBooking.models.Booking;
import com.courseBooking.courseBooking.models.Course;
import com.courseBooking.courseBooking.models.Customer;
import com.courseBooking.courseBooking.repositories.BookingRepository;
import com.courseBooking.courseBooking.repositories.CourseRepository;
import com.courseBooking.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course1 = new Course("Advanced Footeling", "Basingstoke", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Squirrel Dressage", "Perth", 1);
        courseRepository.save(course2);

        Course course3 = new Course("Code Muster", "Durban", 3);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Barry Pheltz", "Dorchester", 59);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Mon Jinton", "Nottingham", 24);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Ray Knockers", "Reyvachol", 35);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("01/06/2023", course1, customer3);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("02/06/2023", course2, customer3);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("25/04/2020", course3, customer2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("01/08/1990", course2, customer2);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("31/12/2092", course3, customer2);
        bookingRepository.save(booking5);
    }
}
