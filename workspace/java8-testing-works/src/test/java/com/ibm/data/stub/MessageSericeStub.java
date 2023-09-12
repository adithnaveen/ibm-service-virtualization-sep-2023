package com.ibm.data.stub;

import java.util.List;

import com.ibm.data.contracts.IMessageService;

public class MessageSericeStub implements IMessageService{

	// imagine this is coming from the DB 
	@Override
	public List<String> getMessages(String user) {
		return List.of(
				"hello good morning all from vani", 
				"i live in delhi from vani",
				"how are you doing from asha",
				"its getting sunny in bengaluru by naveen",
				"now learning mockito from vani"
				);
	}
	
}
