package com.spring.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.project.domain.User;

@Repository
@Transactional
public class UserRepository extends BaseRepository{

	public Long save(User user) {
		return (Long)getSession().save(user);
	}
	
	public void update(User user) {
		getSession().update(user); 
	}
	
	public User getById(Long id) {
		return getSession().get(User.class, id);
	}
	
	public void deleteById(Long id) {
		User user = getById(id);
		getSession().delete(user); 
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		String queryString = "select * from user";
		Query<User> query = getSession().createQuery(queryString);
		return query.list();
		
	}
}
