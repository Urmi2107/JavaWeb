package com.capgemini.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.capgemini.pojo.Address;
import com.capgemini.pojo.Employee;

import com.mysql.jdbc.Connection;

public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	public void insertEmployee(Employee e){  
	    String query="insert into emptbl values('"+e.getEmpId()+"','"+e.getEmpName()+"',"+e.getEmpSalary()+","+e.getEmpCommision()+",'"+e.getEmpDept()+"','"+e.getEmpPhNo()+"')"; 
	    String query2="insert into addresstbl values('"+e.getEmpId()+"','"+e.getAddress().getCity()+"','"+e.getAddress().getState()+"','"+e.getAddress().getPincode()+"')"; 
	     jdbcTemplate.update(query);
	      jdbcTemplate.update(query2);
	} 
	public ArrayList<Employee>getAllEmployees()
	{
		Connection con=null;
		ArrayList<Employee>employeeList=new  ArrayList<Employee>();
		try
		{
			con=(Connection) jdbcTemplate.getDataSource().getConnection();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			String query="select * from emptbl";
			Statement smt1=con.createStatement();
			ResultSet result1=smt1.executeQuery(query);
			 query="select * from addresstbl";
			 Statement smt2=con.createStatement();
			 smt2=con.createStatement();
			 ResultSet result2=smt2.executeQuery(query);
			 while(result1.next() && result2.next()){ 
					employeeList.add(new Employee(result1.getString(1),result1.getString(2),result1.getDouble(3),result1.getDouble(4),result1.getString(5),result1.getString(6),new Address(result2.getString(2),result2.getString(2),result2.getString(3))));
				}
			 return employeeList;
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Employee>getById(String empId)
	{
		Connection con=null;
		ArrayList<Employee>employeeList=new  ArrayList<Employee>();
		try
		{
			con=(Connection) jdbcTemplate.getDataSource().getConnection();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			String query="select * from emptbl where empId='"+empId+"'";
			Statement smt1=con.createStatement();
			ResultSet result1=smt1.executeQuery(query);
			 query="select * from addresstbl where empId='"+empId+"'";
			 Statement smt2=con.createStatement();
			 smt2=con.createStatement();
			 ResultSet result2=smt2.executeQuery(query);
			 while(result1.next() && result2.next()){ 
					employeeList.add(new Employee(result1.getString(1),result1.getString(2),result1.getDouble(3),result1.getDouble(4),result1.getString(5),result1.getString(6),new Address(result2.getString(2),result2.getString(2),result2.getString(3))));
				}
			 return employeeList;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet getHighestSalaryByDept()
	{
		Connection con=null;
		//ArrayList<Employee>employeeList=new  ArrayList<Employee>();
		try
		{
			con=(Connection) jdbcTemplate.getDataSource().getConnection();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			String query="select empDept,max(empSalary) from emptbl group by empDept";
			Statement smt1=con.createStatement();
			ResultSet result1=smt1.executeQuery(query);
			
			return result1;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	public ResultSet updateCommission(String empId,double comm)
	{
		Connection con=null;
		try
		{
			con=(Connection) jdbcTemplate.getDataSource().getConnection();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			String query="update emptbl set empCommision=empCommision+0.5 where empId='"+empId+"'";
			Statement smt1=con.createStatement();
			smt1.executeUpdate(query);
			 query="select empId,empCommision from emptbl where empId='"+empId+"'";
			Statement smt2=con.createStatement();
			ResultSet result1=smt2.executeQuery(query);
			//System.out.println("New Commision:\n Employee ID:"+result1.getString(1)+" Employee Commision:"+result1.getDouble(2));
			return result1;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public void removeEmployeeById(String empId)
	{
		Connection con=null;
		try
		{
			con=(Connection) jdbcTemplate.getDataSource().getConnection();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			
			String query="delete from emptbl  where empId='"+empId+"'";
			Statement smt1=con.createStatement();
			smt1.executeUpdate(query);
			query="delete from addresstbl  where empId='"+empId+"'";
			Statement smt2=con.createStatement();
			smt2.executeUpdate(query);
			//System.out.println("New Commision:\n Employee ID:"+result1.getString(1)+" Employee Commision:"+result1.getDouble(2));
			//return result1;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		//return null;
	}
	
	
	public ResultSet updateNamePhone(String empId)
	{
		Connection con=null;
		try
		{
			con=(Connection) jdbcTemplate.getDataSource().getConnection();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			String name="Juin";
			String ph="954364565";
			String query="update emptbl set empName='"+name+"',empPhNo='"+ph+"' where empId='"+empId+"'";
			Statement smt1=con.createStatement();
			smt1.executeUpdate(query);
			 query="select empId,empName,empPhNo from emptbl where empId='"+empId+"'";
			Statement smt2=con.createStatement();
			ResultSet result1=smt2.executeQuery(query);
			//System.out.println("New Commision:\n Employee ID:"+result1.getString(1)+" Employee Commision:"+result1.getDouble(2));
			return result1;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet updateEmpAddress(String empId)
	{
		Connection con=null;
		try
		{
			con=(Connection) jdbcTemplate.getDataSource().getConnection();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			String city="Bangalore";
			String pin="555066";
			String state="Karnataka";
			String query="update addresstbl set city='"+city+"',pincode='"+pin+"',state='"+state+"' where empId='"+empId+"'";
			Statement smt1=con.createStatement();
			smt1.executeUpdate(query);
			 query="select * from addresstbl where empId='"+empId+"'";
			Statement smt2=con.createStatement();
			ResultSet result1=smt2.executeQuery(query);
			//System.out.println("New Commision:\n Employee ID:"+result1.getString(1)+" Employee Commision:"+result1.getDouble(2));
			return result1;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
}
