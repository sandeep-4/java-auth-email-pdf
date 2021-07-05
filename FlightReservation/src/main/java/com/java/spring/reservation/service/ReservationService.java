package com.java.spring.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.reservation.model.Reservation;
import com.java.spring.reservation.model.ReservationRequest;
import com.java.spring.reservation.repository.ReservationRepository;
import com.java.spring.reservation.repository.ReservationServiceInterfacee;

@Service
public class ReservationService implements com.java.spring.reservation.repository.ReservationServiceInterfacee{

	@Autowired
	ReservationRepository reserveRepo;
	
	@Autowired ReservationServiceInterfacee resSerI;
	
	public List<Reservation> findAllRepo(){
		return reserveRepo.findAll();
	}

	public Reservation insertReservation(Reservation reservation) {
		return reserveRepo.save(reservation);
	}
	
	public Reservation getOne(int id) {
		return reserveRepo.getOne(id);
	}

	public void delete(int id) {
		 reserveRepo.deleteById(id);
	}
	
	

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		return  resSerI.bookFlight(request);

	}
}
