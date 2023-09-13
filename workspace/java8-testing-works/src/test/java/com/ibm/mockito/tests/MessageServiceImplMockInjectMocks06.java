package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ibm.data.business.MessageServiceImpl;
import com.ibm.data.contracts.IMessageService;

class MessageServiceImplMockInjectMocks06 {

	@Mock
	IMessageService iMessageServiceMock; 
	// IMessageService iMessageService = mock(IMessageService.class); 
	
	@InjectMocks
	MessageServiceImpl messageServiceImpl; 
	
	@Test
	void testMessageServiceImpl_ValidCase() {
		List<String> messages = getMessages(); 
		
		when(iMessageServiceMock.getMessages("naveen")).thenReturn(messages); 
		
		List<String> filteredMessages =
			messageServiceImpl.getMessagesFromUser("naveen", "naveen");
		
		assertEquals(2, filteredMessages.size());
		
	}

	private List<String> getMessages() {
		List<String> messages = Arrays.asList("first message from naveen", 
				"first message from kasi", "second message from naveen");
		return messages;
	}
}





















