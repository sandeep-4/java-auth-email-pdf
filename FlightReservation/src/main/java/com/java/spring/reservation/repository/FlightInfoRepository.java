package com.java.spring.reservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.spring.reservation.model.Flight;


@Repository
public interface FlightInfoRepository extends JpaRepository<Flight,Integer>{
	@Query(value="select * from flight where departure_city=:departureCity and arrival_city=:arrivalCity and date_of_departure=:dateOfDeparture",nativeQuery=true)
public List<Flight> findFlights(@Param("departureCity")String from,@Param("arrivalCity")String to,@Param("dateOfDeparture")Date date);

public List<Flight> findByDepartureCityAndArrivalCityAndDateOfDeparture(String from,String to,Date date); 
}
