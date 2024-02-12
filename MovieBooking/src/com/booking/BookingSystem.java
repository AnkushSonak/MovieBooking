package com.booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    public static void main(String[] args) {
        MovieCatalog movieCatalog = new MovieCatalog();
        UserManager userManager = new UserManager();
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Add User\n2. Remove User\n3. Display All Users");
            System.out.println("4. Add Movie\n5. Remove Movie\n6. Display All Movies");
            System.out.println("7. Book a Movie\n8. Display Movies Released in Last Six Months\n9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    String email;
                    do {
                        System.out.print("Enter user email: ");
                        email = scanner.nextLine();
                        if(!userManager.isValidEmail(email)) {
                        	System.out.println("Invalid email address!");
                        }
                    } while (!userManager.isValidEmail(email));
                    try {
                        userManager.addUser(new User(userName, email));
                        System.out.println("User added successfully!");
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case 2:
                    userManager.displayAllUsers();
                    System.out.print("Enter the ID of the user to remove: ");
                    int userIdToRemove = scanner.nextInt()-1;
                    try {
                    User userToRemove = userManager.getUserById(userIdToRemove);
                    if (userToRemove != null) {
                        userManager.removeUser(userToRemove);
                        System.out.println("User removed successfully!");
                    } else {
                        System.out.println("User not found.");
                    }
                    }catch (Exception e) {
						System.err.println("User Id Does't exists!..");
//						continue;
					}
                    break;
                case 3:
                    userManager.displayAllUsers();
                    break;
                case 4:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter movie genre: ");
                    String genre = scanner.nextLine();
                    LocalDate releaseDate;
                    do {
                        System.out.print("Enter release date (yyyy-mm-dd): ");
                        
                        releaseDate = LocalDate.parse(scanner.nextLine());
                    } while (releaseDate == null);
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    System.out.print("Enter available seats: ");
                    int availableSeats = scanner.nextInt();
                    try {
                        movieCatalog.addMovie(new Movie(title, genre, releaseDate, duration, availableSeats));
                        System.out.println("Movie added successfully!");
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case 5:
                    movieCatalog.displayAllMovies();
                    System.out.print("Enter the ID of the movie to remove: ");
                    int movieIdToRemove = scanner.nextInt()-1;
                    try {
                    Movie movieToRemove = movieCatalog.getMovieById(movieIdToRemove);
                    if (movieToRemove != null) {
                        movieCatalog.removeMovie(movieToRemove);
                        System.out.println("Movie removed successfully!");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    }catch (Exception e) {
						System.err.println("Movie with the given id does't exists!..");
						continue;
					}
                    break;
                case 6:
                    movieCatalog.displayAllMovies();
                    break;
                case 7:
                    userManager.displayAllUsers();
                    System.out.print("Enter the ID of the user who wants to book a movie: ");
                    int userId = scanner.nextInt()-1;
                    try {
                    User user = userManager.getUserById(userId);
                    if (user != null) {
                        movieCatalog.displayAllMovies();
                        System.out.print("Enter the ID of the movie to book: ");
                        int movieId = scanner.nextInt()-1;
                        Movie movieToBook = movieCatalog.getMovieById(movieId);
                        if (movieToBook != null) {
                            System.out.print("Enter the number of seats to book: ");
                            int numSeats = scanner.nextInt();
                            if (numSeats <= movieToBook.getAvailableSeats()) {
                                movieToBook.setAvailableSeats(movieToBook.getAvailableSeats() - numSeats);
                                user.bookMovie(movieToBook);
                                System.out.println("Booking successful!");
                            } else {
                                System.out.println("Not enough seats available for booking.");
                            }
                        } else {
                            System.out.println("Movie not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    }catch (Exception e) {
						System.err.println("User Id does't exists!...");
						continue;
					}
                    break;
                case 8:
                    List<Movie> moviesReleasedLastSixMonths = movieCatalog.getMoviesReleasedLastSixMonths();
                    if (!moviesReleasedLastSixMonths.isEmpty()) {
                        System.out.println("Movies Released in Last Six Months:");
                        for (Movie movie : moviesReleasedLastSixMonths) {
                            movie.displayMovieDetails();
                            System.out.println("-----------------------");
                        }
                    } else {
                        System.out.println("No movies released in the last six months.");
                    }
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}