package com.ibm.mockitoworks.contracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibm.mockitoworks.bean.Employee;

@Repository
public interface IEmployeeRepo {
	public List<Employee> getEmployees();
}
