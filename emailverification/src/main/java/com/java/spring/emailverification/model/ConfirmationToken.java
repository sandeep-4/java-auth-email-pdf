package com.java.spring.emailverification.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ConfirmationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tokenId;
	private String confirmationToken;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = User.class)
	@JoinColumn(name = "user_id",nullable = false)
	User user;
	
	
	
	
	public ConfirmationToken(User user) {
		this.user = user;
		createdDate=new Date();
		confirmationToken=UUID.randomUUID().toString();
	}
	public ConfirmationToken() {
		super();
	}
	public ConfirmationToken(Long tokenId, String confirmationToken, Date createdDate, User user) {
		super();
		this.tokenId = tokenId;
		this.confirmationToken = confirmationToken;
		this.createdDate = createdDate;
		this.user = user;
	}
	public Long getTokenId() {
		return tokenId;
	}
	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}
	public String getConfirmationToken() {
		return confirmationToken;
	}
	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
