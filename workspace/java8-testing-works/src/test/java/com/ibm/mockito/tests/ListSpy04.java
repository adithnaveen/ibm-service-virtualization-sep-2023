package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListSpy04 {

	@Test
	@DisplayName("to spy on list - arraylist valid case ")
	void spyListTest_validCase() {
		List<String> listSpy = spy(ArrayList.class);  // behind the screen new ArrayList(); 
		
		assertEquals(0, listSpy.size());
		listSpy.add("Asha"); 
		assertEquals(1, listSpy.size());
	}

	// this test case will fail when you try to add the values 
	// the list will not store as it is only mocked below 
	@Test
	@DisplayName("to mock on list - arraylist valid case ")
	void mockListTest_validCase() {
		List<String> listSpy = mock(ArrayList.class);   
		
		assertEquals(0, listSpy.size());
		listSpy.add("Asha"); 
		assertEquals(1, listSpy.size());
		
		 
	}

}
