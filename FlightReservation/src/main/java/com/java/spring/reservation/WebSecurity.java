package com.java.spring.reservation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
@SuppressWarnings("unused")
public class WebSecurity extends WebSecurityConfigurerAdapter{
 @Bean
public BCryptPasswordEncoder encoder() {
	 return new BCryptPasswordEncoder();
 }
 @Override
 @Bean
 public AuthenticationManager authenticationManagerBean() throws Exception {
     return super.authenticationManagerBean();
 }
 
 @Override
 public void configure(HttpSecurity http) throws Exception {
	
	 http.authorizeRequests()
	 .antMatchers("/","/index.html","/showReg","/registerUser","/login","/showLogin","/login/*")
	 .permitAll()
	 .antMatchers("/reservations","/reservations/*")
	 .permitAll()
	 .antMatchers("/admin/showAddFlight")
	 .hasAnyAuthority("ADMIN")
	 .anyRequest()
	 .authenticated()
	 .and()
	 .csrf().disable();
 }
 
}
