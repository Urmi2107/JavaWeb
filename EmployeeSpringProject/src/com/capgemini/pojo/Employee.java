package com.capgemini.pojo;

public class Employee {
	private String empId;
	private String empName;
	private double empSalary;
	private double empCommision;
	private String empPhNo;
	private String empDept;
	private Address address;
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}

	
	public Employee() {
		System.out.println("Default constructor");
		
	}
	
	

	public Employee(String empId, String empName, double empSalary,
			double empCommision, String empPhNo, String empDept, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empCommision = empCommision;
		this.empPhNo = empPhNo;
		this.empDept = empDept;
		this.address = address;
	}



	public double getEmpCommision() {
		return empCommision;
	}

	public void setEmpCommision(double empCommision) {
		this.empCommision = empCommision;
	}

	public String getEmpPhNo() {
		return empPhNo;
	}

	public void setEmpPhNo(String empPhNo) {
		this.empPhNo = empPhNo;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
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
				+ ", empSalary=" + empSalary + ", empCommision=" + empCommision
				+ ", empPhNo=" + empPhNo + ", empDept=" + empDept + address.toString()+"]";
	}
	
	
	

}
