package com.java.spring.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.reservation.model.Passanger;
import com.java.spring.reservation.repository.PassengersRepositpry;

@Service
public class PassengerService {

	@Autowired
	PassengersRepositpry passRepo;
	
	public Passanger savePassengers(Passanger p) {
		return passRepo.save(p);
	}
}
