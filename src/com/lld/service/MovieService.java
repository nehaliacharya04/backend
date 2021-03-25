package com.lld.service;

import java.util.ArrayList;
import java.util.List;

import com.lld.interfaces.IAddEntity;
import com.lld.model.Movie;

//This service is only responsible for adding new movies
public class MovieService implements IAddEntity<Movie> {
	
	private List<Movie> movies = new ArrayList<>();
	
	@Override
	public List<Movie> add(Movie movie) {
		movies.add(movie);
		return movies;
	}
}
