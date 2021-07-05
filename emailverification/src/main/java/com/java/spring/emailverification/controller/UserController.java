package com.java.spring.emailverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.emailverification.model.ConfirmationToken;
import com.java.spring.emailverification.model.User;
import com.java.spring.emailverification.service.ConfirmationService;
import com.java.spring.emailverification.service.UserService;

@Controller
public class UserController {

	@Autowired 
	UserService userService;
	
	@Autowired
	ConfirmationService confirmationService;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView getRegisterForm(User user,ModelAndView model) {
		model.addObject("user",user);
		model.setViewName("register");
		return model;
	}

	@RequestMapping(value = "/register",method = RequestMethod.POST)
	
	//you dont need @RequestBody on controller but need it in restcontroller
	public String registerIntoDatabase( User user,Model model) {
		User userEmail=userService.findUserByEmail(user.getEmail());
		if(userEmail==null) {
//		User users=userService.saveUser(user);
		
//		model.addAttribute("user", users);

		user.setPassword(bcrypt.encode(user.getPassword()));

		ConfirmationToken confirmationToken=new ConfirmationToken(user);
		confirmationService.saveConfirmationToken(confirmationToken);
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setSubject("Resgisteration sucessfull");
		mail.setFrom("springboottest123@gmail.com");
		mail.setText("To confirm this account click this link : "+"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());
		
		confirmationService.sendEmail(mail);
		model.addAttribute("email", user.getEmail());
		return "sucessfulRegistration";
		}else {
			model.addAttribute("error", "already a username of this exists "+user.getEmail());
			return "error";
		}
	}

	
	@RequestMapping(value="/confirm-account",method = {RequestMethod.GET, RequestMethod.POST})
	public String confirmByToken(@RequestParam("token") String confimToken,Model model) {
		
		ConfirmationToken token=confirmationService.findConfirmationByToken(confimToken);
		if(token !=null) {
			User user=userService.findUserByEmail(token.getUser().getEmail());
			user.setEnabled(true);
			userService.saveUser(user);
			model.addAttribute("add","added sucessfully");
			return "verified";
		}
		else {
			model.addAttribute("error", "token is broken");
			return "error";
		}
	
}

}