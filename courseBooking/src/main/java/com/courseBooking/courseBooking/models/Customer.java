package com.courseBooking.courseBooking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "town")
    private String town;

    @Column(name = "age")
    private int age;

    @JsonIgnoreProperties({"customers"})
    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Customer(String name, String town, int age, List<Booking> bookings) {
        this.name = name;
        this.town = town;
        this.age = age;
        this.bookings = bookings;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public int getAge() {
        return age;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
