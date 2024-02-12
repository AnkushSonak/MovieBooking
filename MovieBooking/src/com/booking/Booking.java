package com.booking;

import java.time.LocalDateTime;

class Booking {
    private static int nextId = 0;

    private int id;
    private LocalDateTime dateTime;
    private Movie movie;
    private User user;

    public Booking(Movie movie, User user) {
        this.id = nextId++;
        this.dateTime = LocalDateTime.now();
        this.movie = movie;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public User getUser() {
        return user;
    }

    public void displayBookingDetails() {
        System.out.println("Booking ID: " + id);
        System.out.println("Date and Time: " + dateTime);
        System.out.println("Movie:");
        movie.displayMovieDetails();
        System.out.println("User:");
        user.displayUserDetails();
    }
}