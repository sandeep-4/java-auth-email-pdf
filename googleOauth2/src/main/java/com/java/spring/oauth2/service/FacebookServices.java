package com.java.spring.oauth2.service;

import org.springframework.social.facebook.api.User;


public interface FacebookServices {
public String facebooklogin();

public String getAcessToken(String code);

public User getFacebookUserProfile(String accessToken);
}
