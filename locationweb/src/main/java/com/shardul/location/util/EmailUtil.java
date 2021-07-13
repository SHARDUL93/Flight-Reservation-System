package com.shardul.location.util;

import org.springframework.stereotype.Component;

@Component
public interface EmailUtil {
	
	void sendEmail(String toAddress, String subject, String body ) ;

}
