
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
    <StyledDiv>
      <StyledH1>OF-COURSE!</StyledH1>
      <StyledP>There are {customers.length} customers</StyledP>
      <StyledP>There are {courses.length} courses</StyledP>
      <StyledP>There are {bookings.length} bookings</StyledP>
      <StyledList>{renderCustomers}</StyledList>
      </StyledDiv>
    </div>
  );
}

const StyledDiv = styled.div`
background: green;
height: 105vh;
margin-top: -22.5px;
`

const StyledList = styled.li`
list-style-type: none;
color: #ebac00;
`

const StyledH1 = styled.h1`
color: #ebac00;
`

const StyledP = styled.p`
color: #ebac00;
`

export default App;
