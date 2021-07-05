package com.java.spring.reservation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.reservation.model.Flight;
import com.java.spring.reservation.repository.FlightInfoRepository;

@Service
public class FlightInfoService {

	@Autowired
	FlightInfoRepository flightRepo;
	
	
	public List<Flight> getAll(){
		return flightRepo.findAll();
	}
	
	public Flight saveFlight(Flight flight) {
		return flightRepo.save(flight);
	}
	
	public Flight getOne(int id) {
		return flightRepo.getOne(id);
	}
	
	public void delete(int id) {
		flightRepo.deleteById(id);
	}
	
	public List<Flight> findFlights(String from,String to,Date date){
		return flightRepo.findFlights(from, to, date);
	}
	
}
