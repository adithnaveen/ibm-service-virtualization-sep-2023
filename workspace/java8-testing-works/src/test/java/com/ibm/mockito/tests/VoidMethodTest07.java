package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibm.data.contracts.IMessageService;

@ExtendWith(MockitoExtension.class)
class VoidMethodTest07 {

	@Mock
	IMessageService messageServiceMock; 
	
	@Mock
	List<String> listMock; 
	
	@Test
	void testvoidMehtod() {
		 messageServiceMock.deleteMessage(1, "Hi");
		 verify(messageServiceMock, atLeastOnce()).deleteMessage(1, "Hi");
	}
 
	@Test
	@DisplayName("To test add(idx, ele) in list interface")
	void testAddList_doesNotReturn_ValidCase() {
		listMock.add(2, "hi");
		verify(listMock, atLeastOnce()).add(2, "hi");
	}
	
}
