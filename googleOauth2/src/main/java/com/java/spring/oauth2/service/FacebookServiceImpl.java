package com.java.spring.oauth2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;


@Service
public class FacebookServiceImpl implements FacebookServices{

	@Value("${spring.social.facebook.app-id}")
	private String facebookId;
	@Value("${spring.social.facebook.app-secret}")
	private String facebookSecret;
	
	private FacebookConnectionFactory connectionFactory() {
		return new FacebookConnectionFactory(facebookId, facebookSecret);
	}
	
	public String getFacebookId() {
		return facebookId;
	}



	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}



	public String getFacebookSecret() {
		return facebookSecret;
	}



	public void setFacebookSecret(String facebookSecret) {
		this.facebookSecret = facebookSecret;
	}



	@Override
	public String facebooklogin() {

		OAuth2Parameters parameters=new OAuth2Parameters();
		parameters.setRedirectUri("http://localhost:8080/facebook");
		parameters.setScope("public_profile,email");
	 
		return connectionFactory().getOAuthOperations().buildAuthenticateUrl(parameters);
	}

	@Override
	public String getAcessToken(String code) {
		
		
		return connectionFactory().getOAuthOperations().exchangeForAccess(code, "http://localhost:8080/facebook", null).getAccessToken();
	}

	@Override
	public User getFacebookUserProfile(String accessToken) {
	Facebook facebook=new FacebookTemplate(accessToken);
	String[] fields= {"id","first_name","last_name","cover","email"};
	
	return facebook.fetchObject("me", User.class,fields);
	}

}
