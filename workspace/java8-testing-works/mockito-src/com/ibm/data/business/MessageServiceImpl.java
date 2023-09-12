package com.ibm.data.business;

import java.util.ArrayList;
import java.util.List;

import com.ibm.data.contracts.IMessageService;

public class MessageServiceImpl {
	private IMessageService ms; 
	
	 
	public MessageServiceImpl(IMessageService ms) {
		this.ms = ms; 
	}
	
	public List<String> getMessagesFromUser(String user) {
		List<String> filteredMessages = new ArrayList<>();  
		
		List<String> messages = ms.getMessages(user);
		
		for(String message: messages) {
			if(message.contains("vani")) {
				filteredMessages.add(message); 
			}
		}
		
		return filteredMessages; 
	}
	
}
