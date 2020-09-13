package com.spring.project.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
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
	public Long save(User user) {
		return userRepository.save(user);

	}

	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> listAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getById(Long id) {
		if (id == null) {
			throw new ObjectNotFoundException(id, "User");
		}
		return userRepository.getById(id);
	}

}
