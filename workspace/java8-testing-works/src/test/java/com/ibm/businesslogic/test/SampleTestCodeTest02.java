package com.ibm.businesslogic.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.ibm.businesslogic.ISampleTestingCode;
import com.ibm.businesslogic.NameInvalidException;
import com.ibm.businesslogic.SampleTestCode;

@TestMethodOrder(OrderAnnotation.class)
class SampleTestCodeTest02 {
	ISampleTestingCode stc = null;

	// guarantee this method will execute before each @Test method
	@BeforeEach
	void setUp() {
		stc = new SampleTestCode();
	}

	@Order(value = 1)
	@Test
	void checkNumberOfNamesInTheListMoreThan0_ValidCase() {
		assertTrue(stc.getName().size() > 0);
	}

	@Order(value = 2)
	@Test
	void checkNameGivenIsValid_ValidCase() {
		String name = "Amita";
		assertTrue(stc.checkName(name));
	}

	@Order(value = 3)
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

	@Order(value = 4)
	@Test
	@DisplayName("to check the name passed is invalid and get an exception")
	void checkNameGivenIsInvalid_ValidCaseForException_lambda() {
		String name = "Amy";
		assertThrows(NameInvalidException.class, () -> stc.checkName(name), "Sorry Invalid Name Passed " + name);
	}

	@Order(5)
	@Test
	@Timeout(unit = TimeUnit.SECONDS, value = 2)
	@DisplayName("To check name is got with in 1 second")
	void checkNameGotWithInOneSecond_ValidCase() {
		String name = "Nidhi";
		String result = stc.delayedName(name);

		assertEquals("Hello " + name, result);
	}

	
	// grouping the test cases 
	@Test
	void groupCaseForNames() {
		assertAll("All Names Related Tests", 
		() -> {
			
			String name = "Amy";
			assertThrows(NameInvalidException.class, 
						() -> stc.checkName(name), "Sorry Invalid Name Passed " + name);
		}, 

		() ->{
			String name = "Amita";
			assertTrue(stc.checkName(name), "To check name given is valid " + name );
		}, 
		
		()->{
			assertTrue(stc.getName().size() > 0, "to check atleast 1 name is there in the list");
		});
	}
	
	
	
	// nested test case 
	
	@Nested
	class NestedTestCases{
		 
		@Test
		void checkNumberOfNamesInTheListMoreThan0_ValidCase() {
			assertTrue(stc.getName().size() > 0);
		}
		 
		@Test
		void checkNameGivenIsValid_ValidCase() {
			String name = "Amita";
			assertTrue(stc.checkName(name));
		}
	}
	
	
	// parameterization 
	
 
	@Disabled
	@DisplayName("To check multiple name for valid case to pass hardcoded values for value source")
	@ParameterizedTest
	@ValueSource(strings = {"Sonali", "Souvik", "Kasaiah", "Pranthi"})
	void checkForMultipleNameValidCase(String name) {
		assertTrue(stc.checkName(name), "invalid name");
	}
	
	
	// parameterization - method source 
	
	@DisplayName("To check multiple name for valid case to pass method source values for value source")
	@ParameterizedTest
	@MethodSource("getNamesToCheck")
	void checkForMultipleNameValidCase_methodSource(String name) {
		assertTrue(stc.checkName(name), "invalid name");
	}
	
	static Stream<String> getNamesToCheck() {
		// connect to external source like .xlsx, db, etc to get the data 
		return Stream.of("Sonali", "Souvik", "Kasaiah", "Pranthi", "Asha Surayanarayana");
	}
	
	
	// parameterization - csv source 
	
	
	@DisplayName("To check multiple name for valid case to pass csv source values for value source")
	@ParameterizedTest
	@CsvFileSource(files = {"src/test/resources/names.csv"}, 
					lineSeparator = "|", 
					numLinesToSkip = 1
					)
	void checkForMultipleNameValidCase_csvSource(String name) {
		assertTrue(stc.checkName(name) , "invalid name : " + name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
