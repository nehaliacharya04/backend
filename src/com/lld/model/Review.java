package com.lld.model;

public class Review {
	private int score;
	private Movie movie;
	private Person user;

	public Review(Person user, Movie movie) {
		this.movie = movie;
		this.user = user;
	}

	public void setScore(int score) {
		if(user.getType().equals(TypeOfUsers.CRITIC)) {
			this.score = score * 2;
		}
		else if(user.getType().equals(TypeOfUsers.VIEWER) && score >= 1 && score <= 10)
			this.score = score;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public int getScore() {
		return score;
	}

}
