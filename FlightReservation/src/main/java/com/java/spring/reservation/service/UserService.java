package com.java.spring.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.reservation.model.User;
import com.java.spring.reservation.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<User> findAllUsers(){
		return userRepo.findAll();
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User getOneUser(int id) {
		return userRepo.getOne(id);
	}
	
	public void delete(int id) {
		userRepo.deleteById(id);
	}
	
	public User findByEmailAndPassword(String email,String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}


	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
}
