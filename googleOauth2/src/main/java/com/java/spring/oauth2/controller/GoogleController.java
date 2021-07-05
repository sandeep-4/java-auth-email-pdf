package com.java.spring.oauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.api.plus.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.java.spring.oauth2.model.UserInfo;
import com.java.spring.oauth2.service.GoogleService;

@Controller
public class GoogleController {
	
	@Autowired
	GoogleService googleService;

	@GetMapping("/googlelogin")
	public RedirectView googleLogin() {
		RedirectView redirectView =new RedirectView();
		String url=googleService.googleLogin();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	@GetMapping("/google")
	public String google(@RequestParam("code") String code) {
		String accessToken=googleService.getGoogleAccesstoken(code);
		System.out.println("redirected");

		return "redirect:/googleprofiledata/"+accessToken;
	}
	
	@GetMapping("/googleprofiledata/{accessToken:.+}")
	public String googleProfileData(@PathVariable String accessToken,Model model) {
System.out.println("before token");
		Person person=googleService.getGoogleUserProfile(accessToken);
		System.out.println("before geeting");
		UserInfo userInfo=new UserInfo(person.getGivenName(),person.getFamilyName(),person.getImageUrl());
		System.out.println("after geeting");
		model.addAttribute("user",userInfo);
		return "view/userprofile";
	}
	
}
