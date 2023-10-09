package com.jsp.userqcoa1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userqcoa1.dao.UserDao;
import com.jsp.userqcoa1.dto.User;

import lombok.Delegate;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
    return userDao.saveUser(user);
	}
	
	
	
	
	
	
	@PutMapping("/update")
	public User updateUser(@RequestParam int userId,@RequestBody User user) {
	return userDao.updateUser(userId,user);
	}
	
	
	@GetMapping("/find")
	public User findUserById( @RequestParam int id) {
		return userDao.findUserById(id);
	}
	@GetMapping("/findall")
	public List<User> findAllUser(){
		return userDao.findAllUser();
	}
	
	@DeleteMapping("/delete")
	public User deleteUserById(@RequestParam int id) {
		return userDao.deleteUserById(id);
	}
	
	
	
	
	
	

}
