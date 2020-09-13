package com.spring.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.project.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
