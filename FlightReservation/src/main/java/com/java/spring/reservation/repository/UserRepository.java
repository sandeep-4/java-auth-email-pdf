package com.java.spring.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.reservation.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByEmailAndPassword(String email,String password);
	
	public User findByEmail(String email);
}
