package com.capgemini.dal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.capgemini.pojo.UserPojo;
import com.capgemini.util.ConnectionFactory;


public class UserDAO {
	
	private Connection connection;
	public UserDAO()
	{
	/* userList=new ArrayList<UserPojo>();
	userList.add(new UserPojo("Urmi","U21101995","User"));
	userList.add(new UserPojo("Dhruba","D12345678","Admin"));
	userList.add(new UserPojo("Supriti","S77259031","User"));
	userList.add(new UserPojo("Kuheli","K12117062","User"));
	userList.add(new UserPojo("Rajdeep","R13130983","User"));*/
		try {
			connection=ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			System.out.println(" MySQL JDBC Driver not found");
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("MySQL JDBC Driver Registered!");
		

	}
	public String getUserType(String userName,String password)throws InvalidUserException, SQLException
	{
		/*for(UserPojo user:userList)
		{
			if(user.getUserName().equals(userName) && user.getPassword().equals(password))
				return user.getUserType();
		}*/
		ArrayList<UserPojo> userPojoList=new ArrayList<UserPojo>();
		Statement stmt=connection.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from userList");  
		while(rs.next()){ 
			userPojoList.add(new UserPojo(rs.getString(1),rs.getString(2),rs.getString(3)));
		}
		for(UserPojo user:userPojoList){
			if(user.getUserName().equals(userName) && user.getPassword().equals(password))
				return user.getUserType();
			}
		
		throw new InvalidUserException("Invalid User");
		
	}
}

