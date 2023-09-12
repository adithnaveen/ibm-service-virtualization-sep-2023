package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ibm.data.business.MessageServiceImpl;
import com.ibm.data.contracts.IMessageService;
import com.ibm.data.stub.MessageSericeStub;

class MessageServiceImplStubTest01 {

	@Test
	void messageServiceImpltest_withStub() {
		IMessageService messageService = new MessageSericeStub(); 
		
		MessageServiceImpl msi = new MessageServiceImpl(messageService);
		
		List<String> filteredMessages = msi.getMessagesFromUser("vani");
		
		assertEquals(3, filteredMessages.size());  
	}

}
