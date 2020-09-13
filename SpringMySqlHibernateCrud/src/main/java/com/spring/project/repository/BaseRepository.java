package com.spring.project.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if(session==null) {
			session = sessionFactory.openSession();
		}
		return session;
		
	}

}
