package com.example.myproject.model;

import org.junit.Test;

import java.time.Duration; // Import Duration class
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    // Test case to calculate flight duration when departure and arrival are on the same day
    @Test
    public void FlightDurationTest() {
        // Create a sample flight
        LocalDateTime departureTime = LocalDateTime.of(2024, 3, 20, 8, 0);
        LocalDateTime arrivalTime = LocalDateTime.of(2024, 3, 20, 12, 0);
        Flight flight = new Flight("ABC", "XYZ", departureTime, arrivalTime);

        // Test calculation of flight duration
        assertEquals(4, flight.calculateFlightDuration());
    }

    // Test case to calculate flight duration when arrival is on the next day
    @Test
    public void FlightDurationTest2() {
        // Create a sample flight
        LocalDateTime departureTime = LocalDateTime.of(2024, 3, 20, 12, 0);
        LocalDateTime arrivalTime = LocalDateTime.of(2024, 3, 21, 11, 0); // Fixed arrival time
        Flight flight = new Flight("New", "Flight", departureTime, arrivalTime);

        // Test calculation of flight duration
        assertEquals(23, flight.calculateFlightDuration()); // Fixed expected duration
    }

    // Test case to calculate flight duration when departure and arrival are on different days
    @Test
    public void FlightDurationTest3() {
        // Create a sample flight
        LocalDateTime departureTime = LocalDateTime.of(2024, 3, 20, 0, 0);
        LocalDateTime arrivalTime = LocalDateTime.of(2024, 3, 21, 12, 0); // Fixed arrival time
        Flight flight = new Flight("ABC", "XYZ", departureTime, arrivalTime);

        // Test calculation of flight duration
        assertEquals(36, flight.calculateFlightDuration()); // Fixed expected duration
    }
}
