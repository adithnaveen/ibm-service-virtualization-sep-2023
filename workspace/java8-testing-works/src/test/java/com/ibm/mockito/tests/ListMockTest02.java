package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
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
	
	@Test
	@DisplayName("to return 2 names Asha (1), Nidhi(2) from the list and assert")
	void mockListValues_validCase() {
		 List listMock = mock(List.class);
		 when(listMock.get(1)).thenReturn("Asha").thenReturn("Nidhi"); 
		 
		 assertEquals("Asha", listMock.get(1));
		 assertEquals("Nidhi", listMock.get(1));
	}
	
	@Test
	@DisplayName("to return 2 names Asha , Nidhi from the list and assert any int ")
	void mockListValues_validCase_anyInt() {
		 List listMock = mock(List.class);
		 when(listMock.get(anyInt())).thenReturn("Asha").thenReturn("Nidhi"); 
		 
		 assertEquals("Asha", listMock.get(3));
		 assertEquals("Nidhi", listMock.get(5));
	}
	
	@Test
	void mockListToThrowAnExceptionWhenSomeSizeGiven_ValidCase() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Sorry Testing To Throw Exception For Mock")); 
		
		assertThrows(RuntimeException.class, () -> listMock.get(1));
	}
	
	@Test
	void mockListToTestSublist_validCase() {
		List listMock = mock(List.class);
		
		when(listMock.subList(4, 4)).thenReturn(List.of("some values"));
		assertEquals("[some values]", listMock.subList(4, 4));
	}

	// this method will not work because of anyInt 
	@Test
	void mockListToTestSublistAnyInt_validCase() {
		List listMock = mock(List.class);
		
		// passing anyInt() here is an illegal argument, pass only finite value 
		when(listMock.subList(anyInt(), anyInt())).thenReturn(List.of("some values"));
		assertEquals("[some values]", listMock.subList(4, 4));
	}
}









