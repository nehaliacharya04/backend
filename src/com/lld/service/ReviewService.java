package com.lld.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import com.lld.enums.TypeOfUsers;
import com.lld.exception.MovieReviewException;
import com.lld.interfaces.IReviewImpl;
import com.lld.model.Movie;
import com.lld.model.Person;
import com.lld.model.Review;

public class ReviewService implements IReviewImpl {

	@Override
	public void addReview(Person user, Movie movie, int score, List<Movie> movies) throws MovieReviewException {
		if (movie.getYear() >= Calendar.getInstance().get(Calendar.YEAR))
			throw new MovieReviewException(MOVIE_YET_TO_RELEASE);
		Review review = new Review(movie);
		review.setScore(user, score);
		if (user.getReviews() == null || user.getReviews().isEmpty()) {
			List<Review> reviewList = new ArrayList<>();
			reviewList.add(review);
			user.setReviews(reviewList);
		} else {
			List<Review> reviews = user.getReviews();
			for (Review r : reviews) {
				if (r.getMovie().getName().equals(movie.getName()))
					throw new MovieReviewException(MULTIPLE_REVIEWS_NOT_ALLOWED);
			}
			if (reviews.size() < 3) {
				reviews.add(review);
				user.setReviews(reviews);
			} else {
				user.setType(TypeOfUsers.CRITIC);
				Review critreview = new Review(movie);
				critreview.setScore(user, score);
				reviews.add(critreview);
			}
		}
	}

	@Override
	public double getAverageReviewScore(List<Person> users, int year) {
		double sum = 0, count = 0;
		for (Person user : users) {
			List<Review> reviews = user.getReviews();
			for (Review r : reviews) {
				if (r.getMovie().getYear() == year) {
					count++;
					sum += r.getScore();
				}
			}
		}
		System.out.print("Average Review Score by Year is: ");
		System.out.printf("%.2f", sum / count);
		System.out.println(" ratings");
		System.out.println();
		return sum / count;
	}

	@Override
	public double getAverageReviewScore(List<Person> users, String entity) {
		double sum = 0, count = 0;
		for (Person user : users) {
			List<Review> reviews = user.getReviews();
			for (Review r : reviews) {
				if (r.getMovie().getGenre().equals(entity)) {
					count++;
					sum += r.getScore();
				} else if(r.getMovie().getName().equals(entity)) {
					count++;
					sum += r.getScore();
				}
			}
		}
		System.out.print("Average Review Score by " + entity + " is: ");
		System.out.printf("%.2f", sum / count);
		System.out.println(" ratings");
		System.out.println();
		return sum / count;
	}

	@Override
	public void getTopMoviesByViewer(int n, int year, List<Person> users) {
		TreeMap<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (Person user : users) {
			List<Review> reviews = user.getReviews();
			for (Review r : reviews) {
				if (r.getMovie().getYear() == year) {
					if (!map.containsKey(r.getMovie().getName()))
						map.put(r.getMovie().getName(), r.getScore());
					else {
						int val = r.getScore() + map.get(r.getMovie().getName());
						map.put(r.getMovie().getName(), val);
					}
				}
			}
		}
		System.out.println("List of top " + n + " movies by review score of Viewers in " + year + " year:");
		printTreeMap(n, map);
		System.out.println();
	}

	@Override
	public void getTopMoviesByViewer(int n, List<Person> users, String genre) {
		TreeMap<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (Person user : users) {
			List<Review> reviews = user.getReviews();
			for (Review r : reviews) {
				if (r.getMovie().getGenre().equals(genre)) {
					if (!map.containsKey(r.getMovie().getName()))
						map.put(r.getMovie().getName(), r.getScore());
					else {
						int val = r.getScore() + map.get(r.getMovie().getName());
						map.put(r.getMovie().getName(), val);
					}
				}
			}
		}
		System.out.println("List of top " + n + " movies by total review score of Viewers in " + genre + " genre:");
		printTreeMap(n, map);
		System.out.println();
	}

	@Override
	public void getTopMoviesByCritics(int n, List<Person> users, int year) {
		TreeMap<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (Person user : users) {
			List<Review> reviews = user.getReviews();
			for (Review r : reviews) {
				if (r.getMovie().getYear() == year && user.getType().equals(TypeOfUsers.CRITIC)) {
					if (!map.containsKey(r.getMovie().getName()))
						map.put(r.getMovie().getName(), r.getScore());
					else {
						int val = r.getScore() + map.get(r.getMovie().getName());
						map.put(r.getMovie().getName(), val);
					}
				}
			}
		}
		System.out.println("List of top " + n + " movies by total review score of Critics in " + year + " year:");
		printTreeMap(n, map);
		System.out.println();
	}

	@Override
	public void getTopMoviesByCritics(int n, List<Person> users, String genre) {
		TreeMap<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (Person user : users) {
			List<Review> reviews = user.getReviews();
			for (Review r : reviews) {
				if (r.getMovie().getGenre().equals(genre) && user.getType().equals(TypeOfUsers.CRITIC)) {
					if (!map.containsKey(r.getMovie().getName()))
						map.put(r.getMovie().getName(), r.getScore());
					else {
						int val = r.getScore() + map.get(r.getMovie().getName());
						map.put(r.getMovie().getName(), val);
					}
				}
			}
		}
		System.out.println("List of top " + n + " movies by total review score of Critics in " + genre + " genre:");
		printTreeMap(n, map);
		System.out.println();
	}
}
