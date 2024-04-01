package com.example.myproject.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    // Test case to calculate total price for a booking with one passenger
    @Test
    public void testCalculateTotalPriceForOnePassenger() {
        // Create a sample flight and user
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("ABC", "XYZ", null, null));
        User user = new User("Billy Bob", "bb@example.com");

        // Create a booking with the flights and user, and one passenger
        Booking booking = new Booking(flights, user, 1);

        // Set the price for the flights
        for (Flight flight : flights) {
            flight.setPrice(150.0);
        }

        // Test calculation of total price
        assertEquals(150.0, booking.calculateTotalPrice(), 0.01);
    }

    // Test case to calculate total price for a booking with two passengers
    @Test
    public void testCalculateTotalPriceForTwoPassengers() {
        // Create a sample flights and user
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("DEF", "XYZ", null, null));
        User user = new User("John Doe", "jd@example.com");

        // Create a booking with the flights and user, and two passengers
        Booking booking = new Booking(flights, user, 2);

        // Set the price for the flights
        for (Flight flight : flights) {
            flight.setPrice(150.0); // Assuming the price per passenger is 150.0
        }

        // Test calculation of total price
        assertEquals(300.0, booking.calculateTotalPrice(), 0.01);
    }


}
