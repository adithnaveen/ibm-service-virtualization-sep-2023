package com.ibm.mockitoworks.bean;

// generate getters and setters 
// default & parametric constructor 
// generate toString method 


public class Employee {
	private int empId;
	private String empName;
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
	 
	public Employee() {
	}
	
	public Employee(String empName) {
		super();
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	} 
}
