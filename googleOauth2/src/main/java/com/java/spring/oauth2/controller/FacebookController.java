package com.java.spring.oauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.java.spring.oauth2.model.UserInfo;
import com.java.spring.oauth2.service.FacebookServices;

@Controller
public class FacebookController {

	@Autowired
	FacebookServices facebookService;
	
	@GetMapping("/facebooklogin")
	public RedirectView facebookLogin() {
		RedirectView redirectView=new RedirectView();
		String url=facebookService.facebooklogin();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	
	@GetMapping("/facebook")
	public String facebook(@RequestParam("code")String code) {
		
		String ascessToken=facebookService.getAcessToken(code);
		return "redirect:/facebookprofiledata/"+ascessToken;
	}
	
	@GetMapping("/facebookprofiledata/{accessToken:.+}")
	public String facebookProfileData(@PathVariable String accessToken,Model model) {
		User user=facebookService.getFacebookUserProfile(accessToken);
		UserInfo userInfo=new UserInfo(user.getFirstName(),user.getLastName(),user.getEmail());
		model.addAttribute("user", userInfo);
		return "view/userprofile";
	}
}
