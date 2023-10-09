package com.jsp.userqcoa1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userqcoa1.dto.User;
import com.jsp.userqcoa1.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);

	}

	
	
	
	public User updateUser(int id, User user) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			user.setId(id);
			return repo.save(user);
		}
		return null;

	}
	
	

	public User findUserById(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
//			inside the optional my user is present
//			i just want to get that user from optional 
			return optional.get();
		}
		return null;
	}

	public List<User> findAllUser() {
		return repo.findAll();

	}

	public User deleteUserById(int id) {
////		3 types of methods are there delete method which is going to accept 
//		the user object which we want to delete and deleteById whoch is going to take 
//		a id and delete the user but the return type of this methods is void 
//				but i want to see the object which i have deleted

		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
//			im going to delete the data
			User user = optional.get();
//			repo.delete(user);
			repo.deleteById(id);

			return user;
		}
		return null;

	}

}
