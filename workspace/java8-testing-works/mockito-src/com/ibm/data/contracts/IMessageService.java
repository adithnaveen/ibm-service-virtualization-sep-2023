package com.ibm.data.contracts;

import java.util.List;

public interface IMessageService {
	public List<String> getMessages(String user); 
	
	public void deleteMessage(Integer messageId, String message); 
}
