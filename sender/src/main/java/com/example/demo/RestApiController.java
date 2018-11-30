package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping(value = "/produce")
	public String produce() {
		String result = "Done";
		
		for (int i = 0; i < 5000; i++) {
			boolean repetir = true;
			while (repetir) {
				try {
					jmsTemplate.convertAndSend("TestTopic", "Message " + i);
					repetir = false;
					result = "Done";
				} catch (JmsException e) {
					e.printStackTrace();
					result = "ERROR";
				}
			}
		}
		return result;
	}
}