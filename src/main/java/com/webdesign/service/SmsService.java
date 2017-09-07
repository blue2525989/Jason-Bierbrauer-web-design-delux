package com.webdesign.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@Service
@Qualifier("smsService")
public class SmsService {
	
	@Autowired
	private AmazonSNSClient snsClient;

    private final String message = "Someone has just visited your web site!";
    
    private final String phoneNumber = "+########";
    
	public void sendSMSMessage() {
		    Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();
		    smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
		            .withStringValue("JasonB") //The sender ID shown on the device.
		            .withDataType("String"));
		    smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
		            .withStringValue("Promotional") //Sets the type to promotional.
		            .withDataType("String"));
		    PublishResult result = snsClient.publish(new PublishRequest()
		                    .withMessage(message)
		                    .withPhoneNumber(phoneNumber)
		                    .withMessageAttributes(smsAttributes));
		    System.out.println(result);
		}
}
