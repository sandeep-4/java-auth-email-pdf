package com.java.spring.reservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	public JavaMailSender mailSender;
	
	public void sendItenerary(String toAddress,String filePath) {
		
	MimeMessage message=mailSender.createMimeMessage();
	
//	new MimeMessageHelper("Reportes !!!","your pdf been gerrated!!!");
	
	try {
		MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
		messageHelper.setTo(toAddress);
		messageHelper.setSubject("your pdf been gerrated!!!");
		messageHelper.setText("Flight Info");
		messageHelper.addAttachment("Inforamtion", new File(filePath));
		
		mailSender.send(message);
	} catch (MessagingException e) {
		e.printStackTrace();
	}

	
	}
}
