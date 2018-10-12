package com.capgemini.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.capgemini.dal.EmployeeDAO;
import com.capgemini.pojo.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r=new ClassPathResource("context.xml");  
	    BeanFactory factory=new XmlBeanFactory(r);  
	      
	    EmployeeDAO dao=(EmployeeDAO)factory.getBean("d");  
	      
	    Employee e=new Employee();  
	    e.setEmpId("111");  
	    e.setEmpName("varun");  
	    e.setEmpDept("CS");
	    e.setEmpSalary(50000);  
	      
	    dao.saveEmployee(e);  

	}

}
