package com.jsp.userqcoa1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.userqcoa1.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
