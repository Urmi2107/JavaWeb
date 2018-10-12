package com.capgemini.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBConnect {
	
	 //static MongoDatabase db =null;
	static DB db =null;
	public static DB getDatabase()
	{
	try{  
		//---------- Connecting DataBase -------------------------//  
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );  
		//---------- Creating DataBase ---------------------------//  
		 //db = mongoClient.getDatabase("dbUser"); 
		db = mongoClient.getDB("dbUser"); 
	}catch(Exception e){  
		System.out.println(e);  
		}
	return db;  

}
	}
