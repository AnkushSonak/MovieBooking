package com.booking;

import java.util.ArrayList;
import java.util.List;

class User {
    private static int nextId = 1;

    private int id;
    private String name;
    private String email;
    private List<Movie> bookedMovies;

    public User(String name, String email) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.bookedMovies = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Movie> getBookedMovies() {
        return bookedMovies;
    }

    public void bookMovie(Movie movie) {
        bookedMovies.add(movie);
    }

    public void displayUserDetails() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        if (!bookedMovies.isEmpty()) {
            System.out.println("Booked Movies:");
            for (Movie movie : bookedMovies) {
                movie.displayMovieDetails();
            }
        } else {
            System.out.println("No movies booked.");
        }
    }
}
