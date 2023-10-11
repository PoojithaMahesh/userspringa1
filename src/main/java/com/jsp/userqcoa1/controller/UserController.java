package com.jsp.userqcoa1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userqcoa1.dao.UserDao;
import com.jsp.userqcoa1.dto.User;
import com.jsp.userqcoa1.service.UserService;
import com.jsp.userqcoa1.util.ResponseStructure;



@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
    return service.saveUser(user);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int userId,@RequestBody User user) {
	return service.updateUser(userId,user);
	}
	
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findUserById( @RequestParam int id) {
		return service.findUserById(id);
	}
	
	
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
		return service.findAllUser();
	}
	
	
	
	
	
	
	
	
	
//	
//	@DeleteMapping("/delete")
//	public User deleteUserById(@RequestParam int id) {
//		return userDao.deleteUserById(id);
//	}
//	
//	
	
	
	
	

}
