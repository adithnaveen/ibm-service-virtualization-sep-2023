package com.ibm.businesslogic.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ibm.businesslogic.ISampleTestingCode;
import com.ibm.businesslogic.SampleTestCode;

class SampleTestCodeTest02 {

	@Test
	void checkNumberOfNamesInTheListMoreThan0_ValidCase() {
		 ISampleTestingCode stc = new SampleTestCode(); 
		 assertTrue(stc.getName().size()>0);
	}

	@Test
	void checkNameGivenIsValid_ValidCase() {
		ISampleTestingCode stc = new SampleTestCode();
		String name = "Amita"; 
		assertTrue(stc.checkName(name));
	}
	
}
