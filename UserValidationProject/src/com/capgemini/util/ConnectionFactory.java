package com.capgemini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//private static ArrayList<UserPojo>userList;
	//private static ArrayList<ProductPojo>productList;
	private static Connection connection;
	public static  Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");  
		 connection=(Connection) DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/myDatabase","root","Oracle@2018"); 
		 return connection;
	}
	/*public static ArrayList<ProductPojo> getConnectionProduct()
	{
		productList=new ArrayList<ProductPojo>();
		return productList;
	}*/
	

}
