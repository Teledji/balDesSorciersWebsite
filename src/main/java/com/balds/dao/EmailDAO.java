package com.balds.dao;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.balds.objects.Email;

@Component
public class EmailDAO{
	
	private final static String EMAIL_ADDRESS_TO_SEND = "balds.me@gmail.com";
	private final static String HOST = "localhost";
	final String username = "balds.me@gmail.com";
	final String password = "BalDesSorciers";
    private Session session; 
    
    private EmailDAO() {
    	Properties properties = new Properties();
    	properties.put("mail.smtp.auth", "true");
    	properties.put("mail.smtp.starttls.enable", "true");
    	properties.put("mail.smtp.host", "smtp.gmail.com");
    	properties.put("mail.smtp.port", "587");
    	
		session = Session.getInstance(properties,
				  	new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});
    }
	
	public boolean sendEmail(Email email) {
		boolean response = false;
		try {
			// Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(EMAIL_ADDRESS_TO_SEND));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getAddress()));

	         // Set Subject: header field
	         message.setSubject("[BALDS] Message from " + email.getName());

	         // Now set the actual message
	         message.setText(email.getContent());

	         // Send message
	         Transport.send(message);
	         
	         // Message correctly send
	         response = true;
		} catch (MessagingException mex) {
	         mex.printStackTrace();
	    }
		
		return response;
	}
}
