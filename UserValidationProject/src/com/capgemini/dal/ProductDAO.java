package com.capgemini.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.capgemini.pojo.ProductPojo;
import com.capgemini.pojo.UserPojo;
import com.capgemini.util.ConnectionFactory;

public class ProductDAO {
	private Connection connection;
	public  ProductDAO()
	{
		try {
			connection=ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			System.out.println(" MySQL JDBC Driver not found");
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void addProduct(String productId,String productName,Double productPrice) throws SQLException
	{
		Statement stmt=connection.createStatement();  
		int count=stmt.executeUpdate("INSERT INTO productList VALUES ('"+productId+"','"+ productName+"',"+productPrice+")"); 
		System.out.println(count);
		//while(rs.next()){ 
	}
	public ArrayList<ProductPojo> viewProduct() throws SQLException
	{
		ArrayList<ProductPojo> productPojoList=new ArrayList<ProductPojo>();
		Statement stmt=connection.createStatement(); 
		ResultSet rs=stmt.executeQuery("select * from productList");
		while(rs.next()){ 
			productPojoList.add(new ProductPojo(rs.getString(1),rs.getString(2),rs.getDouble(3)));
		}
		
		return productPojoList;  
		
		}
	public  void deleteProduct(String productId) throws SQLException
	{
		Statement stmt=connection.createStatement(); 
		int count=stmt.executeUpdate("delete from productList where productId='"+productId+"'");
	}
	public  void updateProduct(String productId,String productName,double productPrice) throws SQLException
	{
		Statement stmt=connection.createStatement(); 
		int count=stmt.executeUpdate("update productList set productName='"+productName+"',productPrice="+ productPrice+" where productId='"+productId+"'");
	}
	

}
