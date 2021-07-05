package com.java.spring.emailverification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.spring.emailverification.model.User;
import com.java.spring.emailverification.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	public List<User> findAllUSer(){
		return userRepository.findAll();
	}
	
	public User findOne(long id) {
		return userRepository.getOne(id);
				
	}
	public User saveUser(User user) {
	return userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	
	public User findUserByEmail(String email) {
	return	userRepository.findByEmail(email);
	}
}
