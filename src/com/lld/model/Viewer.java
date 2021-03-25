package com.lld.model;

import java.util.List;

public class Viewer extends Person {

	public Viewer(String name, List<Review> reviews) {
		this.name = name;
		this.reviews = reviews;
		this.type = TypeOfUsers.VIEWER;
	}
	
	public Viewer(String name) {
		this.name = name;
		this.type = TypeOfUsers.VIEWER;
	}

}
