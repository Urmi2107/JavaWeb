package com.capgemini.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.dal.EmployeeDAO;
import com.capgemini.pojo.Address;
import com.capgemini.pojo.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("Context.xml");  
	      
	    EmployeeDAO emp=(EmployeeDAO)context.getBean("edao");  
	           
	     System.out.println("------Records Creation--------" );
	  //  Address address=new Address("Kolkata","West Bengal","700054");
	    
	   emp.insertEmployee(new Employee("001","ABC",39000,500,"986314312","CSE",new Address("Kolkata","West Bengal","700054")));
	   emp.insertEmployee(new Employee("002","XYZ",36000,580,"986318892","CSE",new Address("Kolkata","West Bengal","700015")));
	   emp.insertEmployee(new Employee("003","Urmi",20000,500,"986318892","IT",new Address("Kolkata","West Bengal","700054")));
	   
	   System.out.println("------Displaying all Records --------" );
	   ArrayList<Employee>employeeList=new ArrayList<Employee>();
	   employeeList=emp.getAllEmployees();
	   System.out.println(employeeList);
	   System.out.println("------Displaying Records By ID --------" );
	   ArrayList<Employee>employeeListById=new ArrayList<Employee>();
	   employeeListById=emp.getById("002");
	   System.out.println(employeeListById);
	   
	   System.out.println("------Displaying Highest Salary by Department  --------" );
	 ResultSet result= emp.getHighestSalaryByDept();
	 try {
		while(result.next())
		 {
			System.out.println("Department:"+result.getString(1)+" Salary:"+result.getDouble(2)); 
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 System.out.println("------Displaying updated Commision--------" ); 
	result= emp.updateCommission("003",500); 
	 try {
			while(result.next())
			 {
				System.out.println("Employee Id:"+result.getString(1)+" Commission:"+result.getDouble(2)); 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 System.out.println("------Displaying Employees after removal--------" ); 
	 emp.removeEmployeeById("002");
	// ArrayList<Employee>employeeList=new ArrayList<Employee>();
	   employeeList=emp.getAllEmployees();
	   System.out.println(employeeList);
	 
	   System.out.println("------Displaying updated Name and Phone no.--------" );  
	 result= emp.updateNamePhone("003"); 
	 try {
			while(result.next())
			 {
				System.out.println("Employee Id:"+result.getString(1)+" Employee Name:"+result.getString(2)+" Employee Phone no.:"+result.getString(3)); 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 System.out.println("------Displaying updated Address--------" ); 
	 result= emp.updateEmpAddress("003"); 
	 try {
			while(result.next())
			 {
				System.out.println("Employee Id:"+result.getString(1)+" Employee City:"+result.getString(2)+" Employee State:"+result.getString(3)+" Employee pin:"+result.getString(4)); 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
