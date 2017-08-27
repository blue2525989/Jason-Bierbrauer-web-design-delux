package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;


@Service("mailService")
public class EmailService {

	 // Replace with a "To" address. If your account is still in the
    // sandbox, this address must be verified.
    static final String TO = "blue9892525@gmail.com";
    
    @Autowired
    public BasicAWSCredentials creds;
    
    @SuppressWarnings("deprecation")
    public String sendMail(String name, String phone, String email, 
    	    String subject,  String body) {

    	if (phone == null || phone == "") {
    		phone = "no phone #";
    	}
    	SendEmailRequest request = new SendEmailRequest()
 		       .withSource(TO);
 		
 		List<String> toAddresses = new ArrayList<String>();
 		toAddresses.add(TO);
 		Destination dest = new Destination().withToAddresses(toAddresses);
 		
 		// set fromEmail as BCC
 		List<String> toBccAddresses = new ArrayList<String>();
 		toBccAddresses.add(TO);
 		dest.setBccAddresses(toBccAddresses);
 		request.setDestination(dest);
 		
 		Content subjContent = new Content().withData(phone +" "+ name +" "+ subject +" "+ email);
 		Message msg = new Message().withSubject(subjContent);
 		
 		
 		// Include a body in HTML formats.
 		Content htmlContent = new Content().withData("Phone number: " + phone 
 				+"<br/>"+ "<h2>Name:</h2> " + name 
 				+"<br/>"+ "<h2>Subject:</h2>"+ subject
 				+"<br/>"+ "<h2>Email address:</h2> " + email
 				+"<br/><br/><h2>Message,</h2><br/>"+ body);
 		Body message = new Body().withHtml(htmlContent);
 		msg.setBody(message);
 		
 		request.setMessage(msg);
 		
 		// Set AWS access credentials.
 		AmazonSimpleEmailServiceClient client =
 		       new AmazonSimpleEmailServiceClient(creds).withRegion(Regions.US_WEST_2);
 		
 		// Call Amazon SES to send the message. 
 		try {
 		   client.sendEmail(request);
 		
 		} catch (AmazonClientException e) {
 		   return e.getMessage();
 		} catch (Exception e) {
 		   return e.getMessage();
 		}
		String saved = "Thank you, " + name + ", "
				+ "your email is on the way and will be responded to shortly.";
 	 	return saved;
 		
    }	

}
