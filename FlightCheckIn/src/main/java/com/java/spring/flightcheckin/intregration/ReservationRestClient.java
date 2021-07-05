package com.java.spring.flightcheckin.intregration;

import com.java.spring.flightcheckin.model.Reservation;
import com.java.spring.flightcheckin.model.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(int id);
	public Reservation updateReservation(ReservationUpdateRequest request);

}
