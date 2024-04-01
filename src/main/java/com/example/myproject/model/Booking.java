package com.example.myproject.model;

import java.util.List;

public class Booking {
    private List<Flight> flights;
    private User user;
    private int numberOfPassengers;

    public Booking(List<Flight> flights, User user, int numberOfPassengers) {
        this.flights = flights;
        this.user = user;
        this.numberOfPassengers = numberOfPassengers;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public double calculateTotalPrice() {
        // Assuming the price per passenger is stored in the Flight object as price
        double totalPrice = 0.0;
        for (Flight flight : flights) {
            totalPrice += flight.getPrice();
        }
        return totalPrice * numberOfPassengers;
    }
}
