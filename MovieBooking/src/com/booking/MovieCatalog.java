package com.booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MovieCatalog {
    private List<Movie> movies;

    public MovieCatalog() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            System.out.println("All Movies:");
            for (Movie movie : movies) {
                movie.displayMovieDetails();
                System.out.println("-----------------------");
            }
        }
    }

    public List<Movie> getMoviesReleasedLastSixMonths() {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        return movies.stream()
                .filter(movie -> movie.getReleaseDate().isAfter(sixMonthsAgo))
                .collect(Collectors.toList());
    }

	public Movie getMovieById(int movieIdToRemove) {
		return movies.get(movieIdToRemove);
	}
}