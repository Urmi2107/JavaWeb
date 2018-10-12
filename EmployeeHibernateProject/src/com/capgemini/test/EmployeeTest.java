package com.capgemini.test;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO emp=new EmployeeDAO();
		Employee e=new Employee();
		e.setEmpId("001");
		e.setEmpName("ABC");
		e.setEmpDept("CS");
		e.setEmpSalary(30000);
		emp.insertNative(e);
		
		
		e.setEmpId("002");
		e.setEmpName("XYZ");
		e.setEmpDept("CS");
		e.setEmpSalary(40000);
		emp.insertFunction(e);
		
		
		e.setEmpId("003");
		e.setEmpName("Juin");
		e.setEmpDept("CS");
		e.setEmpSalary(50000);
		emp.insertFunction(e);
		
		
		 emp.hqlSelect();
		 emp.nativeSelect();
		 emp.criteriaSelect();
		 
		 
		 emp.nativeUpdate("Urmi", "001");
		 emp.hqlUpdate("OOPS", "002");
		
		 emp.nativeDelete("003");
		 emp.hqlDelete("002");
		 emp.criteriaDelete("001");
	}

}
