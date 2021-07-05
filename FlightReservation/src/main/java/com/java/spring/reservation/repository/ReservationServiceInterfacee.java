package com.java.spring.reservation.repository;

import com.java.spring.reservation.model.Reservation;
import com.java.spring.reservation.model.ReservationRequest;

public interface ReservationServiceInterfacee {
	public Reservation bookFlight(ReservationRequest request);

}
