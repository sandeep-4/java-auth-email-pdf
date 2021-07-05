package com.java.spring.oauth2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class GoogleServiceImpl implements GoogleService {

	@Value("${spring.social.google.app-id}")
	private String googleId;
	@Value("${spring.social.google.app-secret}")
	private String googleSecret;

	// getters and stters were missing
	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getGoogleSecret() {
		return googleSecret;
	}

	public void setGoogleSecret(String googleSecret) {
		this.googleSecret = googleSecret;
	}

	private GoogleConnectionFactory googleConnectionFactory() {
		return new GoogleConnectionFactory(googleId, googleSecret);
	}

	@Override
	public String googleLogin() {

		OAuth2Parameters parameters = new OAuth2Parameters();
		parameters.setRedirectUri("http://localhost:8080/google");
		parameters.setScope("profile");
		return googleConnectionFactory().getOAuthOperations().buildAuthenticateUrl(parameters);

	}

	@Override
	public String getGoogleAccesstoken(String code) {

		return googleConnectionFactory().getOAuthOperations()
				.exchangeForAccess(code, "http://localhost:8080/google", null).getAccessToken();
	}

	@Override
	public Person getGoogleUserProfile(String accessToken) {

		Google google = new GoogleTemplate(accessToken);
		Person person = google.plusOperations().getGoogleProfile();
		return person;

	}

}
