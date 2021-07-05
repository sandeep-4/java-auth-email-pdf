package com.java.spring.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.java.spring.reservation.repository.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService{

	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	AuthenticationManager authManger;
	
	@Override
	public boolean login(String username, String password) {
     UserDetails userDetails = userDetailsService.loadUserByUsername(username);
     
     
     UsernamePasswordAuthenticationToken token =new UsernamePasswordAuthenticationToken(userDetails, password,
    		 userDetails.getAuthorities());
		
     
     authManger.authenticate(token);
     
     boolean result=token.isAuthenticated();
     
     if(result) {
    	 //this enable the user to be cotniune being logged in
    	 
    	 SecurityContextHolder.getContext().setAuthentication(token);
     }
     
     return result;
     
     
	}

}
