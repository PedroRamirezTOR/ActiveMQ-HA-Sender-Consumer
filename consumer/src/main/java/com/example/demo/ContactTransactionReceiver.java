package com.example.demo;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ContactTransactionReceiver {

	@JmsListener(destination = "TestTopic")
	public void receiveMessageSendMessage(Message message) throws Exception {
		System.out.println(((TextMessage) message).getText());
	}
}