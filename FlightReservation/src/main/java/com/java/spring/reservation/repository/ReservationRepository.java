package com.java.spring.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.reservation.model.Flight;
import com.java.spring.reservation.model.Reservation;
import com.java.spring.reservation.model.ReservationRequest;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

	public List<Reservation> findByFlight(Flight flight);
	
}
