package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibm.data.business.MessageServiceImpl;
import com.ibm.data.contracts.IMessageService;


// junit 4 
//@RunWith(MockitoJunitRunner.class)

// junit 5 
@ExtendWith(MockitoExtension.class)
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





















