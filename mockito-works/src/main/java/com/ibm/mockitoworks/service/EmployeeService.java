package com.ibm.mockitoworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.mockitoworks.bean.Employee;
import com.ibm.mockitoworks.contracts.IEmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private IEmployeeRepo repo; 
	
	public List<Employee> getEmployees() {
		return repo.getEmployees(); 
	}
}
