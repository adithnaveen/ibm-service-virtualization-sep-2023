package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.data.business.MessageServiceImpl;
import com.ibm.data.contracts.IMessageService;
import com.ibm.data.stub.MessageSericeStub;

class MessageServiceImplStubTest01 {

	@Test
	void messageServiceImpltest_withStub() {
		IMessageService messageService = new MessageSericeStub(); 
		
		MessageServiceImpl msi = new MessageServiceImpl(messageService);
		
		List<String> filteredMessages = msi.getMessagesFromUser("vani", "vani");
		
		filteredMessages.forEach(System.out :: println);
		assertEquals(3, filteredMessages.size());  
	}

	
	@Test
	void messageServiceImplTest_withMock() {
		IMessageService messageServiceMock = mock(IMessageService.class); 
		
		List<String> list = List.of(
				"hello good morning all from vani", 
				"i live in delhi from vani",
				"how are you doing from asha",
				"its getting sunny in bengaluru by naveen",
				"now learning mockito from vani"
				);
		
		when(messageServiceMock.getMessages("vani")).thenReturn(list); 
		
		MessageServiceImpl msi = new MessageServiceImpl(messageServiceMock);
		List<String> filteredMessages = msi.getMessagesFromUser("vani", "vani"); 
		assertEquals(3, filteredMessages.size()); 
		
	}
	
	@Test
	@DisplayName("to test empty list ")
	void messageSerivceImplTestMock_emptyList() {
	IMessageService messageServiceMock = mock(IMessageService.class); 
		
		List<String> list = List.of();
		
		when(messageServiceMock.getMessages("vani")).thenReturn(list); 
		
		MessageServiceImpl msi = new MessageServiceImpl(messageServiceMock);
		List<String> filteredMessages = msi.getMessagesFromUser("vani", "anything"); 
		assertEquals(0, filteredMessages.size()); 
	}
	
	

	@Test
	@DisplayName("to test not matching ")
	void messageSerivceImplTestMock_notMatchingValues() {
	IMessageService messageServiceMock = mock(IMessageService.class); 
		
	List<String> list = List.of(
			"hello good morning all from vani", 
			"i live in delhi from vani",
			"how are you doing from asha",
			"its getting sunny in bengaluru by naveen",
			"now learning mockito from vani"
			);
		
		when(messageServiceMock.getMessages("vani")).thenReturn(list); 
		
		MessageServiceImpl msi = new MessageServiceImpl(messageServiceMock);
		List<String> filteredMessages = msi.getMessagesFromUser("vani", "priyanka"); 
		assertEquals(0, filteredMessages.size()); 
	}
	
	@Test
	void toDeleteTheMessageWithIdAndString_valiCase_mock() {
		// TODO 
	}
}
