package com.java.spring.emailverification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.java.spring.emailverification.model.ConfirmationToken;
import com.java.spring.emailverification.repository.ConfirmationTokenReository;

@Service
public class ConfirmationService {

	@Autowired
	ConfirmationTokenReository confirmationRepo;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public List<ConfirmationToken> findAllConfirmation(){
		return confirmationRepo.findAll();
	}
	
	public ConfirmationToken findOne(Long id) {
		return confirmationRepo.getOne(id);
	}
	
	public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {
		return confirmationRepo.save(confirmationToken);
	}
	public void delete(Long id) {
		confirmationRepo.deleteById(id);
	}
	
	public ConfirmationToken findConfirmationByToken(String confirmationToken) {
		return confirmationRepo.findByConfirmationToken(confirmationToken);
	}
	
	@Async
	public void sendEmail(SimpleMailMessage email) {
		javaMailSender.send(email);
	}
}
