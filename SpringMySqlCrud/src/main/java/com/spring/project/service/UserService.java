package com.spring.project.service;

import java.util.List;

import com.spring.project.domain.User;


public interface UserService {

	User save(User user);

	void delete(Long id);

	List<User> listAll();

}
