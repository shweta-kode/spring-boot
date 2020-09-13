package com.spring.project.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class DBConfig {
	
	@Value("${jdbc.driverClassName}")
	private String driverClass;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	@Bean
	@Autowired
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getDataSource()); 
		sf.setHibernateProperties(getHibernateProperties()); 
		sf.setPackagesToScan(new String[] { "com.spring.project.domain" });
		return sf;
	}
	
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.putIfAbsent("hibernate.dialect", dialect);
		properties.putIfAbsent("hibernate.ddl-auto", "update");
		properties.putIfAbsent("hibernate.show_sql", "true");
		properties.putIfAbsent("hibernate.format_sql", "true");
		return properties;
	}
	

}
