package com.courseBooking.courseBooking.repositories;

import com.courseBooking.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
