package com.java.spring.flightcheckin.model;





public class Passanger {
 
	int id;
	String firstname;
	String lastname;
	String middlename;
	String email;
	String phone;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Passanger [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", middlename="
				+ middlename + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
