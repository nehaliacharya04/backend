package com.lld.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.lld.exception.MovieReviewException;
import com.lld.model.Movie;
import com.lld.model.Person;

public interface IReviewImpl {

	String MOVIE_YET_TO_RELEASE = "Movie yet to be released";
	String MULTIPLE_REVIEWS_NOT_ALLOWED = "Multiple reviews for the same movie not allowed";

	public void addReview(Person user, Movie movie, int score, List<Movie> movies) throws MovieReviewException;

	public void getTopMoviesByYearByViewer(int n, int year, List<Person> user);

	public void getTopMoviesByGenreByViewer(int n, List<Person> users, String genre);

	public void getTopMoviesByYearsByCritics(int n, List<Person> users, int year);

	public void getTopMoviesByGenreByCritics(int n, List<Person> users, String genre);

	public double getAverageReviewScoreByYear(List<Person> users, int year);

	public double getAverageReviewScoreByGenre(List<Person> users, String genre);

	public double getAverageReviewScoreForMovie(List<Person> users, String movie);

	default void printTreeMap(int n, TreeMap<String, Integer> map) {
		LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		List<String> alKeys = new ArrayList<String>(sortedMap.keySet());
		Collections.reverse(alKeys);
		while (n > 0) {
			for (String strKey : alKeys) {
				if (n > 0 && alKeys.size() >= n)
					System.out.println(strKey + " - " + sortedMap.get(strKey) + " ratings");
				n--;
			}
		}
	}
}
