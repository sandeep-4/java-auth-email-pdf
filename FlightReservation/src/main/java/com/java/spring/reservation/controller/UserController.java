package com.java.spring.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.reservation.model.User;
import com.java.spring.reservation.repository.SecurityService;
import com.java.spring.reservation.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	UserService userService;
	
	public static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	SecurityService securityService;
	
	@RequestMapping("/user")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/showReg")
	public String registerUsersPage() {
		LOGGER.info("show registerUsersPage()");
		return "login/registerUser";
	}
	
	@RequestMapping("/showLogin")
	public String loginUsersPage() {
		LOGGER.info("show login page()");

		return "login/logins";
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user")User user) {
//		LOGGER.info("show registerUsersPage()"+user);
		
    user.setPassword(encoder.encode(user.getPassword()));

		User users=userService.saveUser(user);
		if(users!=null) {
			return "login/logins";
		}else {
			return "cant register";
		}
	}
	
//	@RequestMapping(value="/logins",method= {RequestMethod.POST,RequestMethod.GET})
//	public String loginUser(@RequestParam(value="email",required=false)String email,@RequestParam(value="password",required=false)String password ,Model model) {
//		User user=userService.findByEmailAndPassword(email, password);
//		if(user!=null) {
//			return "findFlights";
//		}else{
//			model.addAttribute("msg","Error of your email or passowrd");
//
//			return "login/login";
//		}
//	}
	
	//This method is without encryptin method.
	
	
	@RequestMapping(value="/loginwoencription",method={RequestMethod.POST,RequestMethod.GET})
	public String loginUserByEmailss(@RequestParam(value="email")String email,@RequestParam(value="password")String password,Model model) {
		
		LOGGER.info("display !!! loginUserByEmail"+email);
		
		User user=userService.findByEmail(email);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}else{
			model.addAttribute("msg","Error of your emailor passowrd");
			return "login/logins";
		}
	}
	
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	public String loginUserByEmail(@RequestParam(value="email")String email,@RequestParam(value="password")String password,Model model) {
		
		LOGGER.info("display !!! loginUserByEmail"+email);
		
		boolean user=securityService.login(email, password);
		if(user) {
			return "findFlights";
		}else{
			model.addAttribute("msg","Error of your emailor passowrd");
			return "login/logins";
		}
	}
	
	
}
