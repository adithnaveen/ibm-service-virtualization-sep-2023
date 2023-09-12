package com.ibm.businesslogic.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.ibm.businesslogic.ISampleTestingCode;
import com.ibm.businesslogic.NameInvalidException;
import com.ibm.businesslogic.SampleTestCode;

class SampleTestCodeTest02 {
	ISampleTestingCode stc = null; 
	
	// guarantee this method will execute before each @Test method 
	@BeforeEach
	void setUp() {
		 stc = new SampleTestCode();
	}
	
	@Test
	void checkNumberOfNamesInTheListMoreThan0_ValidCase() {
		assertTrue(stc.getName().size() > 0);
	}

	@Test
	void checkNameGivenIsValid_ValidCase() {
		String name = "Amita";
		assertTrue(stc.checkName(name));
	}

	@Test
	void checkNameGivenIsInvalid_ValidCaseForException() {
		String name = "Amy";

		assertThrows(NameInvalidException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				stc.checkName(name);
			}
		}, "Sorry Invalid Name Passed " + name);
	}
	
	
	@Test
	void checkNameGivenIsInvalid_ValidCaseForException_lambda() {
		String name = "Amy";

		assertThrows(NameInvalidException.class, () ->  
				stc.checkName(name)
		 , "Sorry Invalid Name Passed " + name);
	}
}



