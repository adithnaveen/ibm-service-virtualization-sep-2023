package com.ibm.mockitoworks.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ibm.mockitoworks.bean.Employee;
import com.ibm.mockitoworks.contracts.IEmployeeRepo;

@Component
public class EmployeeDAO implements IEmployeeRepo {

	static Map<Integer, Employee> map;
	static int count;
	// create a static list / map
	// store in at the application scope

	public EmployeeDAO() {
		map = new HashMap<>();
		count = 1;
	}

	// assume that data to be pulled from DB

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) map.values();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setEmpId(count);
		return map.put(count++, employee);
	}

	@Override
	public Employee getEmployee(int empId) {
		return map.get(empId);
	}

}
