package com.lld.model;

import java.util.List;

public class Movie {
	
	private String name;
	private int year;
	private String genre;
	private List<Review> reviews;

	public Movie(String name, int year, String genre) {
		this.name = name;
		this.year = year;
		this.genre = genre;
	}
	
	public Movie(String name, int year, String genre, List<Review> reviews) {
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.reviews = reviews;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}
}
