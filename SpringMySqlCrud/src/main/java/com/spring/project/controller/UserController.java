package com.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.domain.User;
import com.spring.project.service.UserService;


@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("index")
	public String welcome() {
		System.out.println("In index controller");
		return "Welcome";
	}
	
	@PostMapping("save")
	public User save(@RequestBody User user) {
		System.out.println("Request to save user"+user);
		return userService.save(user);
	}
	
	@PostMapping("update")
	public User update(@RequestBody User user) {
		System.out.println("Request to update user"+user);
		return userService.save(user);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		System.out.println("Request to delete user"+id);
		userService.delete(id);
		return "Deleted successfully";
	}
	
	@GetMapping("list")
	public List<User> listAll(){
		return userService.listAll();
	}
	
	

}
