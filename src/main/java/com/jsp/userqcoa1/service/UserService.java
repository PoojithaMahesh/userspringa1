package com.jsp.userqcoa1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.userqcoa1.dao.UserDao;
import com.jsp.userqcoa1.dto.User;
import com.jsp.userqcoa1.exception.UserIdNotFoundException;
import com.jsp.userqcoa1.util.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
	User dbUser=userDao.saveUser(user);
	ResponseStructure<User> structure=new ResponseStructure<User>();
	structure.setMessage("User Data Saved successfully");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(dbUser);
	return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}

	
	public ResponseEntity<ResponseStructure<User>> updateUser(int userId, User user) {
		User dbUser=userDao.updateUser(userId, user);
		if(dbUser!=null) {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("User Data Updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}else {
			
            throw new UserIdNotFoundException("Sorry failed to update the data");
		}
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		User dbUser=userDao.findUserById(id);
		if(dbUser!=null) {
//			id is present and we fetched the data from the database
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("User Data Fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);	
		}
		else {
			throw new UserIdNotFoundException("Sorry failed to fetch the data");
		}
	}

	
	
	
	
	
	
	
	
	
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> users=userDao.findAllUser();
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
		structure.setMessage("entire data fetched successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(users);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
	}

	
	
	
	
	
	
	
	
	
	
}
