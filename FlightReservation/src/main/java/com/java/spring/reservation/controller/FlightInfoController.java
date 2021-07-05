package com.java.spring.reservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.reservation.model.Flight;
import com.java.spring.reservation.model.ReservationRequest;
import com.java.spring.reservation.service.FlightInfoService;

@Controller
public class FlightInfoController {

	@Autowired
	FlightInfoService flightService;
	
	static final Logger LOGGER=LoggerFactory.getLogger(FlightInfoController.class);

	
	@RequestMapping(value="findFlights",method= {RequestMethod.GET,RequestMethod.POST})
	public String findFlight(@RequestParam("from") String from,@RequestParam("to")String to,@RequestParam("departuredate") @DateTimeFormat(pattern="yyyy-MM-dd") Date departureDate,Model model) {
	LOGGER.info("your inside findFlight");
		List<Flight> flights=	flightService.findFlights(from,to,departureDate);
		
		model.addAttribute("flights",flights);
		return "displayFlights";
	}
	
	@RequestMapping("/showCompleteResevations")
	public String showAllReservation(@RequestParam("id")int id,Model model) {
		LOGGER.info("your inside showAllReservation");
	Flight flight=flightService.getOne(id);
	model.addAttribute("flight",flight);
		
		return "showResevation";
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String CompleteReservation(ReservationRequest request) {
		return null;
	}
	
	@RequestMapping("admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}
}
