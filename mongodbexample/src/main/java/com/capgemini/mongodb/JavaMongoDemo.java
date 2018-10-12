package com.capgemini.mongodb;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class JavaMongoDemo {
	//MongoDatabase db=DBConnect.getDatabase();
	DB db=DBConnect.getDatabase();
	//---------- Creating Collection -------------------------//  
	//MongoCollection<Document> table = db.getCollection("restaurants");
	DBCollection table = db.getCollection("restaurants");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//try{  
			  
			//---------- Creating Document ---------------------------//    
			//Document doc = new Document("name", "Peter John");  
			//doc.append("id",12);  
			//----------- Inserting Data ------------------------------//  
			//table.insertOne(doc);  
			/*}catch(Exception e){  
			System.out.println(e);  
			} */
		JavaMongoDemo mongo=new JavaMongoDemo();
		//mongo.displayAll();
		//mongo.display2();
		//mongo.display3();
		//mongo.display4();
		//mongo.display5();
		//mongo.display6();
		//mongo.display7();
		//mongo.display8();
		//mongo.display9();
		mongo.display10();

	}
	public  void displayAll()
	{
		DBCursor iterDoc = table.find(); 
	      int i = 1; 

	      // Getting the iterator 
	      Iterator it = iterDoc.iterator(); 
	    
	      while (it.hasNext()) {  
	         System.out.println(it.next());  
	      i++; 
	      }
	}
	public void display2()
	{
		// Create query and fields
		BasicDBObject query = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();

		// Assign 1 or 0 for projecting a specific field.
		fields.put("restaurant_id", 1);
		fields.put("name", 1);
		fields.put("borough", 1);
		fields.put("cuisine", 1);

		// Pass query and fields to find()
		DBCursor cursor =table.find(query, fields);
		while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
		
	}
	public void display3() {
		// TODO Auto-generated method stub
		// Create query and fields
				BasicDBObject query = new BasicDBObject();
				BasicDBObject fields = new BasicDBObject();

				// Assign 1 or 0 for projecting a specific field.
				fields.put("_id",0);
				fields.put("restaurant_id", 1);
				fields.put("name", 1);
				fields.put("borough", 1);
				fields.put("cuisine", 1);

				// Pass query and fields to find()
				DBCursor cursor =table.find(query, fields);
				while(cursor.hasNext()){
		            System.out.println(cursor.next());
		        }
		
	}
	public void display4() {
		// TODO Auto-generated method stub
		// Create query and fields
		BasicDBObject query = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();

		// Assign 1 or 0 for projecting a specific field.
		fields.put("_id",0);
		fields.put("restaurant_id", 1);
		fields.put("name", 1);
		fields.put("borough", 1);
		fields.put("address.zipcode", 1);

		// Pass query and fields to find()
		DBCursor cursor =table.find(query, fields);
		while(cursor.hasNext()){
            System.out.println(cursor.next());
        }

		
	}
	public void display5() {
		// TODO Auto-generated method stub
		// Create query and fields
				BasicDBObject query = new BasicDBObject();
				BasicDBObject fields = new BasicDBObject();
				query.put("borough", "Bronx");
				// Assign 1 or 0 for projecting a specific field.
				fields.put("restaurant_id", 1);
				fields.put("name", 1);
				// Pass query and fields to find()
				DBCursor cursor =table.find(query, fields);
				while(cursor.hasNext()){
		            System.out.println(cursor.next());
		        }
	}
	
	public void display6() {
	// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		query.put("borough", "Bronx");
		// Assign 1 or 0 for projecting a specific field.
		fields.put("restaurant_id", 1);
		fields.put("name", 1);
		// Pass query and fields to find()
		DBCursor cursor =table.find(query, fields).limit(5);
		while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
			
}
	
	public void display7() {
		// TODO Auto-generated method stub
			BasicDBObject query = new BasicDBObject();
			BasicDBObject fields = new BasicDBObject();
			query.put("borough", "Bronx");
			// Assign 1 or 0 for projecting a specific field.
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			// Pass query and fields to find()
			DBCursor cursor =table.find(query, fields).skip(5).limit(5);
			while(cursor.hasNext()){
	            System.out.println(cursor.next());
	        }
				
	}
	public void display8() {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		query.put("grades.score", new BasicDBObject("$gt",90));
		// Assign 1 or 0 for projecting a specific field.
		fields.put("restaurant_id", 1);
		fields.put("name", 1);
		// Pass query and fields to find()
		DBCursor cursor =table.find(query, fields);
		while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
			
		
	}
	public void display9() {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		query.put("grades.score", new BasicDBObject("$gt",80).append("$lt",100));
		//query.put("grades.score", new BasicDBObject("$lt",100));
		// Assign 1 or 0 for projecting a specific field.
		fields.put("restaurant_id", 1);
		fields.put("name", 1);
		fields.put("grades.score",1);
		// Pass query and fields to find()
		DBCursor cursor =table.find(query, fields);
		while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
			
	}
	public void display10() {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		query.put("address.coord", new BasicDBObject("$lt",-95.754168));
		
		// Assign 1 or 0 for projecting a specific field.
		fields.put("restaurant_id", 1);
		fields.put("name", 1);
		fields.put("address.coord",1);
		// Pass query and fields to find()
		DBCursor cursor =table.find(query, fields);
		while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
			
	}

}
