package com.ibm.mockito.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;

// Given - WillReturn
// When - Then Return
class ListMockBDDStyle03 {

	@Test
	@DisplayName("to show the mock of list with BDD style- given will return ")
	void mockListwithBDDStyle_ValidCase_given() {
		// Pre Condition 
		// Given 
		List<String> mockList = mock(List.class); 
		given(mockList.get(1)).willReturn("Harry"); 
		
		
		// Actual - Happening 
		String element = mockList.get(1); 
		
		// Post Condition 
		assertEquals("Harry", element);
	}

	
	@Test
	@DisplayName("to show the mock of list with BDD style- when then return  ")
	void mockListwithBDDStyle_ValidCase_when() {
		List<String> mockList = mock(List.class); 
		when(mockList.get(anyInt())).thenReturn("Peter"); 
		
		String element = mockList.get(3);
		
		assertEquals("Peter", element);
		
	}
	
	// to work with set 
	@Test 
	@DisplayName("to add an element into the set and validating if its inserted.")
	void mockSetWithBDDStyle_toAddElement_ValidCase() {
		Set<String> setMock = mock(Set.class); 
		
		// pre condition 
		given(setMock.add(anyString())).willReturn(true); 
		
		// actual 
		boolean returnValue = setMock.add("Kumar");
		
		// test / post condition 
		assertTrue(returnValue);; 
		
		
	}
	
	// TODO 
	// try to have a mock implementation for map for get method 
	
	class TestEmployeeObject {
		private int empId; 
		private String empName;
		
		public TestEmployeeObject() {
		}
		
		public TestEmployeeObject(int empId, String empName) {
			super();
			this.empId = empId;
			this.empName = empName;
		}

		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		} 
		
		
	}
	
	@Test
	@DisplayName("have a mock implementation for map for get method")
	void mockMapWithBDDStyle_ToGetObjectValue_ValidCase() {
		Map<Integer, TestEmployeeObject> mapMock = mock(Map.class);
		
		given(mapMock.get(101)).willReturn(new TestEmployeeObject(101, "Naveen")); 
		
		TestEmployeeObject returnEmp = mapMock.get(101);
		
		assertEquals("Naveen", returnEmp.getEmpName());
		assertEquals(101, returnEmp.getEmpId());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
