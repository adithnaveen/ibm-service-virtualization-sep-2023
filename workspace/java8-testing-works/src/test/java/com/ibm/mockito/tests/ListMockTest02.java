package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListMockTest02 {

	@Test
	void mockListSize_validCase() {
		 List listMock = mock(List.class);
		 
		 when(listMock.size()).thenReturn(2);  
		 
		 assertEquals(2, listMock.size());
	}

	@Test
	void mockListSizeMultipleValues_validCase() {
		 List listMock = mock(List.class);
		 when(listMock.size()).thenReturn(2).thenReturn(3); 
		 
		 assertEquals(2, listMock.size());
		 assertEquals(3, listMock.size());
	}
	
}
