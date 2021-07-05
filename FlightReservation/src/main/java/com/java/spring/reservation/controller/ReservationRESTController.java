package com.java.spring.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.reservation.dto.ReservationUpdateRequest;
import com.java.spring.reservation.model.Reservation;
import com.java.spring.reservation.service.ReservationService;

@RestController
public class ReservationRESTController {

	@Autowired
	ReservationService resService;
	
	@RequestMapping("reservations/{id}")
	public Reservation findReservation(@PathVariable(name="id")int id) {
		Reservation res=resService.getOne(id);
		return res;
		
	}
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation=resService.getOne(request.getId());
		reservation.setNoOfBags(request.getNoOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
		Reservation updated=resService.insertReservation(reservation);
		return updated;
	}
}
