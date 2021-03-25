package com.lld.service;

import java.util.ArrayList;
import java.util.List;

import com.lld.interfaces.IAddEntity;
import com.lld.model.Person;
import com.lld.model.Viewer;

//This service is only for adding/creating new users
public class UserService implements IAddEntity<Person> {

	private List<Person> viewers = new ArrayList<>();
	
	@Override
	public List<Person> add(Person entity) {
		viewers.add(entity);
		return viewers;
	}

}
