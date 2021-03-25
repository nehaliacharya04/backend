package com.lld.model;

import java.util.List;

public class Person {
	String name;
	TypeOfUsers type;
	List<Review> reviews;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public TypeOfUsers getType() {
		return type;
	}
	
	public void setType(TypeOfUsers type) {
		this.type = type;
	}
}	
