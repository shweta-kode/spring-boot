package com.spring.project.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -110849570730813576L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dob;



}
