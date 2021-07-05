package com.java.spring.flightcheckin.model;


public class Reservation {
	
	int id;
	Boolean checkedIn;
	int noOfBags;
	Flight flight;
	Passanger passanger; 
	

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

	

}
