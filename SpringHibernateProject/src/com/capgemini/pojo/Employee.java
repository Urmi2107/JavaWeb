package com.capgemini.pojo;

public class Employee {
	private String empId;  
	private String empName;
	private String empDept;
	private double empSalary;
	public Employee()
	{
		
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empDept=" + empDept + ", empSalary=" + empSalary + "]";
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
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
	 
	  

}
