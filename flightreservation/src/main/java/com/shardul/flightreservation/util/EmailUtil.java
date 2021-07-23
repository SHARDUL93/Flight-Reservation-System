package com.shardul.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class EmailUtil {
	
	@Value("${com.shardul.flightreservation.itinerary.email.subject}")
	private String EMAIL_SUBJECT ;
	
	@Value("${com.shardul.flightreservation.itinerary.email.body}")
	private String EMAIL_BODY ;
	
	@Autowired
	private JavaMailSender sender;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	public void sentItineary(String toAddress, String filePath) {
		
		LOGGER.info("Inside sentItineary()");
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject(EMAIL_SUBJECT);
			mimeMessageHelper.setText(EMAIL_BODY);
			mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
			
			sender.send(mimeMessage);
		} catch (MessagingException e) {
			LOGGER.error("Exception inside sentItineary() "+e);
			e.printStackTrace();
		}
		
	}

}
