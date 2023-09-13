package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.data.business.MessageServiceImpl;
import com.ibm.data.contracts.IMessageService;

class MessageserviceImpSpyTest05 {

	@Test
	@DisplayName("to test message service with actuals - spy ")
	void testMessageServiceImplStub_validCase() {
		 IMessageService messageServiceSpy = spy(IMessageService.class);
		 
		 ArrayList messagesSpy = spy(ArrayList.class);
		 
		 // earliest we used List List.of(....); 
		 
		 messagesSpy.add("Bala says its good morning"); 
		 messagesSpy.add("its good weather in bengaluru by naveen"); 
		 messagesSpy.add("metro cities are too traffice by kasi"); 
		 messagesSpy.add("interesting places near south india by Bala");
		 
		 when(messageServiceSpy.getMessages("naveen")).thenReturn(messagesSpy); 
		 
		 
		 
		 //////////////////////////////////
		 
		 messageServiceSpy.getMessages("naveen"); 
		 
		 ///////////////////////////////////
		 
		 MessageServiceImpl msImpl = new MessageServiceImpl(messageServiceSpy); 
		 List<String> filteredMessages = msImpl.getMessagesFromUser("naveen", "Bala");
		 
		 assertEquals(2, filteredMessages.size());
		 
		 
	}

}
