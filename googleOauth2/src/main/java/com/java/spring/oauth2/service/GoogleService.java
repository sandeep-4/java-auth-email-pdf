package com.java.spring.oauth2.service;

import org.springframework.social.google.api.plus.Person;

public interface GoogleService {

	public String googleLogin();

	public String getGoogleAccesstoken(String token);

	public Person getGoogleUserProfile(String token);

}
