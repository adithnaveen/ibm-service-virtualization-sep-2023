package com.ibm.mockitoworks.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.mockitoworks.bean.Employee;
import com.ibm.mockitoworks.contracts.IEmployeeRepo;


@Component
public class EmployeeDAO implements IEmployeeRepo{

	// assume that data to be pulled from DB 
	
	@Override
	public List<Employee> getEmployees() {
		return List.of(new Employee(101, "Pranathi"), new Employee(102, "Prachi")); 
	}

}
