package com.java.spring.reservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation {
	@Id
	int id;
	Boolean checkedIn;
	int noOfBags;
	@OneToOne
	Flight flight;
	@OneToOne
	Passanger passanger;
	
	public Reservation() {
		super();
	}
	public Reservation(int id, Boolean checkedIn, int noOfBags, Flight flight, Passanger passanger) {
		super();
		this.id = id;
		this.checkedIn = checkedIn;
		this.noOfBags = noOfBags;
		this.flight = flight;
		this.passanger = passanger;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNoOfBags() {
		return noOfBags;
	}
	public void setNoOfBags(int noOfBags) {
		this.noOfBags = noOfBags;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Passanger getPassanger() {
		return passanger;
	}
	public void setPassanger(Passanger passanger) {
		this.passanger = passanger;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkedIn=" + checkedIn + ", noOfBags=" + noOfBags + ", flight=" + flight
				+ ", passanger=" + passanger + "]";
	}

}
