package com.java.spring.reservation.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.reservation.model.Flight;
import com.java.spring.reservation.model.Passanger;
import com.java.spring.reservation.model.Reservation;
import com.java.spring.reservation.model.ReservationRequest;
import com.java.spring.reservation.service.FlightInfoService;
import com.java.spring.reservation.service.PassengerService;
import com.java.spring.reservation.service.ReservationService;
import com.java.spring.reservation.util.EmailUtil;
import com.java.spring.reservation.util.PDFGenerator;

@Controller
public class ReservationController {

	public static class ReservationControllersData {
		@Autowired
		public ReservationService revService;
		@Autowired
		public FlightInfoService filghtService;
		@Autowired
		public PassengerService passService;
		@Autowired
		public PDFGenerator pdfGenerator;
		@Autowired
		public EmailUtil emailUtil;

		public ReservationControllersData() {
		}
	}

	ReservationControllersData data = new ReservationControllersData();

	static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

//	@RequestMapping("/")
//	public String showReservation(@RequestParam("flightid")int id,Model model) {
//	Reservation rev=revService.getOne(id);
//	model.addAttribute("reservation",rev);
//		
//		return "showResevation";
//	}

	@RequestMapping("/showCompleteResevation")
	public String showAllReservation(@RequestParam("id") int id, Model model) {
		LOGGER.info("this is showAllReservation");

		Flight flight = data.filghtService.getOne(id);
		model.addAttribute("flight", flight);

		return "showResevation";
	}

	@Transactional
	@RequestMapping(value = "/completeReservations", method = { RequestMethod.POST, RequestMethod.GET })
	public String bookAFlight(ReservationRequest request, Model model) {
		LOGGER.info("this is bookAFlight");

		int id = request.getId();
		Flight flight = data.filghtService.getOne(id);

		Passanger passanger = new Passanger();
		passanger.setFirstname(request.getFirstname());
		passanger.setLastname(request.getLastname());
		passanger.setEmail(request.getEmail());
		passanger.setPhone(request.getPhone());
		data.passService.savePassengers(passanger);
		Passanger saved = data.passService.savePassengers(passanger);
		LOGGER.info("passenger saved!!!" + saved);
		Reservation reservation = new Reservation();

		reservation.setFlight(flight);
		reservation.setPassanger(saved);
		reservation.setCheckedIn(false);

		Reservation revSaved = data.revService.insertReservation(reservation);

		LOGGER.info("reservation saved!!!" + revSaved);

		model.addAttribute("msg", "sucessfully added" + request.getId());

		String filePath = "C:/Users/sandeep/Documents/demo/reservation" + revSaved.getId() + ".pdf";

		data.pdfGenerator.generateInteratory(revSaved, filePath);
		LOGGER.info("pdf generated !!!");

		data.emailUtil.sendItenerary(passanger.getEmail(), filePath);
		LOGGER.info("email generated !!!");

		return "completeReservation";
	}

}
