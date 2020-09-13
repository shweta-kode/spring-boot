package com.spring.project.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.domain.User;
import com.spring.project.repository.UserRepository;
import com.spring.project.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
		
	}

	@Override
	public void delete(Long id) {
		 userRepository.deleteById(id);
	}

	@Override
	public List<User> listAll() {
		return (List<User>) userRepository.findAll();
	}

}
