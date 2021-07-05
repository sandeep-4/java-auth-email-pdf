package com.java.spring.emailverification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.emailverification.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
	
}
