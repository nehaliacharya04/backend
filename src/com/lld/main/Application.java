package com.lld.main;

import java.util.ArrayList;
import java.util.List;

import com.lld.exception.MovieReviewException;
import com.lld.model.Movie;
import com.lld.model.Person;
import com.lld.model.Viewer;
import com.lld.service.MovieService;
import com.lld.service.ReviewService;
import com.lld.service.UserService;

public class Application {

	public static void main(String[] args) throws MovieReviewException {

		// add movies
		MovieService movieService = new MovieService();
		List<Movie> movies = new ArrayList<>();
		movies = movieService.add(new Movie("Don", 2006, "Action & Comedy"));
		movies = movieService.add(new Movie("Tiger", 2008, "Drama"));
		movies = movieService.add(new Movie("Padmaavat", 2006, "Comedy"));
		movies = movieService.add(new Movie("Lunchbox", 2021, "Drama"));
		movies = movieService.add(new Movie("Guru", 2006, "Drama"));
		movies = movieService.add(new Movie("Metro", 2006, "Romance"));
		movies = movieService.add(new Movie("3 idiots", 2009, "Drama"));
		movies = movieService.add(new Movie("Kahaani", 2011, "Drama"));
		movies = movieService.add(new Movie("Go Goa Gone", 2010, "Romance"));
		movies = movieService.add(new Movie("Goal", 2007, "Drama"));

		// add users
		UserService userService = new UserService();
		List<Person> users = new ArrayList<>();
		users = userService.add(new Viewer("SRK"));
		users = userService.add(new Viewer("Salman"));
		users = userService.add(new Viewer("Deepika"));

		// add reviews
		ReviewService reviewService = new ReviewService();
		reviewService.addReview(users.get(0), movies.get(0), 2, movies);
		reviewService.addReview(users.get(0), movies.get(2), 8, movies);
		reviewService.addReview(users.get(1), movies.get(0), 5, movies);
		reviewService.addReview(users.get(2), movies.get(0), 9, movies);
		//reviewService.addReview(users.get(0), movies.get(0), 10, movies); //multiple reviews not allowed exception
		//reviewService.addReview(users.get(2), movies.get(3), 5); //movie not yet released exception
		reviewService.addReview(users.get(0), movies.get(1), 5, movies);
		reviewService.addReview(users.get(0), movies.get(5), 7, movies);
		reviewService.addReview(users.get(1), movies.get(4), 6, movies);
		
		reviewService.getAverageReviewScore(users, 2006);
		reviewService.getAverageReviewScore(users, "Drama");
		reviewService.getAverageReviewScore(users, "Don");
		reviewService.getTopMoviesByViewer(1, 2006, users);
		reviewService.getTopMoviesByViewer(2, users, "Drama");
		reviewService.getTopMoviesByCritics(3, users, 2006);
		reviewService.getTopMoviesByCritics(1, users, "Romance");
	}
}
