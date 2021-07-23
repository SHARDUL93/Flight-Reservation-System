package com.shardul.flightreservation.util;

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
	private JavaMailSender sender;
	
	public void sentItineary(String toAddress, String filePath) {
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject("Itinerary for your Flight");
			mimeMessageHelper.setText("Please find your Itinerary attached.");
			mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
			
			sender.send(mimeMessage);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}

}
