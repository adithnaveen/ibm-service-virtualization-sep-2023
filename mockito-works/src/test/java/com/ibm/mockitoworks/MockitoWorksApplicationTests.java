package com.ibm.mockitoworks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.mockitoworks.bean.Employee;
import com.ibm.mockitoworks.contracts.IEmployeeRepo;
import com.ibm.mockitoworks.service.EmployeeService;

@SpringBootTest // this annotation will load the context i.e., tomcat is started 
@ExtendWith(SpringExtension.class) // to execute as junit case 
class MockitoWorksApplicationTests {

	
	@Mock
	private IEmployeeRepo repoMock;
	
	@InjectMocks
	private EmployeeService service; 
	
	@Test
	void toCheckToHaveZeroRecordsOfEmployees_validCase() {
		when(repoMock.getEmployees()).thenReturn(List.of()); 
		assertEquals(0, service.getEmployees().size()); 
	}
	
	@Test
	void toCheckToHaveMoreThanZeroRecordsOfEmployees_validCase() {
		when(repoMock.getEmployees()).thenReturn(List.of(new Employee("Vani"), new Employee("Asha"))); 
		assertEquals("Vani", service.getEmployees().get(0).getEmpName());
	}
	@Disabled
	@Test
	void toAddEmployeeToTheMap_validCase() {
		
	}
	@Disabled
	@Test
	void toGetSingleEmployeeAndCheckForName_ValidCase() {
		
	}
}









