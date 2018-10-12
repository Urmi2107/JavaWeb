package com.capgemini.springTest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =   
			    new ClassPathXmlApplicationContext("applicationContext.xml");  
		Employee emp=(Employee)context.getBean("Employee");
		emp.toString();
		

	}

}
