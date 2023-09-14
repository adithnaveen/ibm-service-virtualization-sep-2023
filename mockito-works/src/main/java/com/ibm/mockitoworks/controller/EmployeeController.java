package com.ibm.mockitoworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mockitoworks.bean.Employee;
import com.ibm.mockitoworks.service.EmployeeService;

// by default tomcat loads on 8080
// http://localhost:8080/employees 
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service; 
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return service.getEmployees(); 
	}
	
	public Employee getEmployee(int empId) {
		return service.getEmployee(empId); 
		
	}
	
	public Employee saveEmployee(Employee employee) {
		return service.saveEmployee(employee); 
	}
}
