package com.spring.project.service;

import java.util.List;

import com.spring.project.domain.User;


public interface UserService {

	Long save(User user);

	void delete(Long id);

	List<User> listAll();
	
	User getById(Long id);

	void update(User user);

}
