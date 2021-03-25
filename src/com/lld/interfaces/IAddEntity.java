package com.lld.interfaces;

import java.util.List;

/**
 * This generic interface has one method to add an entity (user or movie) that can be implemented by 
 * UserService and MovieService according to their requirements (to add a user/ to add a movie). 
*/
public interface IAddEntity<T> {
	public List<T> add(T entity);
}
