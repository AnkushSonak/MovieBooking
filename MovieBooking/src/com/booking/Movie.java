package com.booking;

import java.time.LocalDate;

class Movie {
    private static int nextId = 1;

    private int id;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private int duration; // in minutes
    private int availableSeats;

    public Movie(String title, String genre, LocalDate releaseDate, int duration, int availableSeats) {
        this.id = nextId++;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void displayMovieDetails() {
        System.out.println("Movie ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Available Seats: " + availableSeats);
    }
}