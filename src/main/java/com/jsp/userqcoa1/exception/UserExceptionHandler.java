package com.jsp.userqcoa1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.userqcoa1.util.ResponseStructure;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> idExceptionHandler(UserIdNotFoundException ex){
		
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("User Id Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
}
