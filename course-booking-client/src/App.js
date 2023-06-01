
import styled from "styled-components";
import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';

function App() {

const [customers, setCustomers] = useState([]);
const [courses, setCourses] = useState([]);
const [bookings, setBookings] = useState([]);

useEffect(() => {
  getCustomers(); 
  getCourses();
  getBookings(); 
}, [])

const getCustomers = () => {
  fetch('http://localhost:8080/customers')
  .then(res => res.json())
  .then(data => setCustomers(data))
}

const getCourses = () => {
  fetch('http://localhost:8080/courses')
  .then(res => res.json())
  .then(data => setCourses(data))
}

const getBookings = () => {
  fetch('http://localhost:8080/bookings')
  .then(res => res.json())
  .then(data => setBookings(data))
}

const renderCustomers = customers.map(customer => {
  return(<li>{customer.name} is on {customer.bookings.length} courses</li>)
})

  return (
    <div className="App">
      <p>There are {customers.length} customers</p>
      <p>There are {courses.length} courses</p>
      <p>There are {bookings.length} bookings</p>
      <ul>{renderCustomers}</ul>
    </div>
  );
}

export default App;
