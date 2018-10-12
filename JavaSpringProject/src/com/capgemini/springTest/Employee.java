package com.capgemini.springTest;

public class Employee {
	private String empId;
	private String empName;
	private double empSalary;
	public Employee() {
		System.out.println("Default constructor");
		
	}
	public Employee(String empId, String empName, double empSalary) {
		System.out.println("Parameterized constructor");
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSalary=" + empSalary + "]";
	}
	
	

}
