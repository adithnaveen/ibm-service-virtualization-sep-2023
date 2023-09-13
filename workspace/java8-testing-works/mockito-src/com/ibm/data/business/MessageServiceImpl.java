package com.ibm.data.business;

import java.util.ArrayList;
import java.util.List;

import com.ibm.data.contracts.IMessageService;

// SUT - system under test 
public class MessageServiceImpl {
	private IMessageService ms; 
	
	 
	// by now mocked object has come 
	public MessageServiceImpl(IMessageService ms) {
		this.ms = ms; 
	}
	
	public List<String> getMessagesFromUser(String user, String containingWord) {
		List<String> filteredMessages = new ArrayList<>();  
		
		List<String> messages = ms.getMessages(user);
		
		// some business logic 
		for(String message: messages) {
			if(message.contains(containingWord)) {
				filteredMessages.add(message); 
			}
		}
		
		return filteredMessages; 
	}
	
}
