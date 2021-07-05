package com.java.spring.flightcheckin.intregration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.java.spring.flightcheckin.model.Reservation;
import com.java.spring.flightcheckin.model.ReservationUpdateRequest;
@Component
public class ReservationRestClientImpl implements ReservationRestClient{

	public static final String RESERVATION_REST_URL="http://localhost:8080/reservations/";
	@Override
	public Reservation findReservation(int id) {

		RestTemplate template=new RestTemplate();
		return template.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		
		
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate template=new RestTemplate();

return		template.postForObject("http://localhost:8080/reservations/", request, Reservation.class);
	}

}
