package com.java.spring.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.flightcheckin.intregration.ReservationRestClient;
import com.java.spring.flightcheckin.model.Reservation;
import com.java.spring.flightcheckin.model.ReservationUpdateRequest;

@Controller
public class CheckInController {

	@Autowired
	ReservationRestClient resClient;
	
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("id") int id,Model model) {
	Reservation reservation=resClient.findReservation(id);
	model.addAttribute("reservation",reservation);
		
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckedIn")
	public String completeCheckedIn(@RequestParam("id") int id,@RequestParam("noofbags")int numberofbags) {
		ReservationUpdateRequest updateReservation=new ReservationUpdateRequest();
		updateReservation.setId(id);
		updateReservation.setCheckedIn(true);
		updateReservation.setNoOfBags(numberofbags);
		resClient.updateReservation(updateReservation);
		return "completeCheckedIn";
	}
	
	
	
}
