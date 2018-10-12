package com.capgemini.test;

import java.util.ArrayList;




import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;

public class EmployeeDAO {

	
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr;
        Metadata meta ; 
        SessionFactory factory; 
       Transaction t ;  
       Session session;
    int result=0;
    public EmployeeDAO()
    {
    	ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        factory = meta.getSessionFactoryBuilder().build();  
    
    }
    public void insertNative(Employee e)
    {
    	Session session = factory.openSession(); 
    	t = session.beginTransaction();  
   Query query =session.createNativeQuery("INSERT INTO emptbl1 " +
            " VALUES(?,?,?,?)");
     query.setParameter(1, e.getEmpId());
     query.setParameter(2, e.getEmpName());
     query.setParameter(3, e.getEmpDept());
     query.setParameter(4, e.getEmpSalary());
     query.executeUpdate();
     System.out.println("successfully saved"); 
     t.commit(); 
     session.close();
    }
    public void insertFunction(Employee e1)
    {
    	session = factory.openSession(); 
    	t = session.beginTransaction();  
        session.save(e1); 
    System.out.println("successfully saved");    
    t.commit(); 
    session.close();
    }
    
    public void hqlSelect()
    {
    	session = factory.openSession(); 
    	t = session.beginTransaction();  
  
    Query query=session.createQuery("from Employee");
    List list=query.list();
    System.out.println(list);
    t.commit(); 
    session.close();
    }
    
    public void nativeSelect()
    {
    	session = factory.openSession(); 
    	t = session.beginTransaction();  
   SQLQuery query1 =session.createSQLQuery("select * from emptbl1");
   query1.addEntity(Employee.class);
   List list1=query1.list();
   Iterator itr=list1.iterator();
   while(itr.hasNext()){
	   Employee e=(Employee) itr.next();
   System.out.println(e.getEmpId());
   System.out.println(e.getEmpName());
   System.out.println(e.getEmpDept());
   System.out.println(e.getEmpSalary());
   }
   t.commit(); 
   session.close();
    }
   
    public void criteriaSelect()
    {
    	session = factory.openSession(); 
    	t = session.beginTransaction();  
   Criteria cr = session.createCriteria(Employee.class);
   List results = cr.list();
   System.out.println(results);
   t.commit(); 
   session.close();
    }
    /*String hql = "INSERT INTO Employee(empId, empName, empDept,empSalary)"  + 
            "SELECT empId, empName, empDept,empSalary e1";
 int result = session.createQuery(hql).executeUpdate();
System.out.println("Rows affected: " + result);*/
          //Query <Employee> query = session.createQuery("from Employee");
   //  ArrayList<Employee> list = (ArrayList<Employee>) query.list();
    // System.out.println(list);
  // session.save(e1);  
    //emp = (Employee) session.get;
   // System.out.println(emp);
     // System.out.println("successfully saved");
    public void nativeUpdate(String name,String id)
    {
    	session = factory.openSession(); 
    	t = session.beginTransaction();  
   String sql = "UPDATE emptbl1 set empName ='"+name+"'WHERE empId ='"+id+"'";
 Query query = session.createNativeQuery(sql);
 result = query.executeUpdate();
System.out.println("Rows updated: " + result);
t.commit(); 
session.close();
    }
    public void hqlUpdate(String name,String id)
    {
    	session = factory.openSession(); 
    	t = session.beginTransaction();  
 Query query=session.createQuery("update Employee set empName=:n where empId=:i");  
query.setParameter("n",name);  
query.setParameter("i",id);  
 result=query.executeUpdate();  
System.out.println("Rows updated: " + result);
t.commit();  
session.close();
    }
public void nativeDelete(String id)
{
	session = factory.openSession(); 
	t = session.beginTransaction();  
 String sql = "delete from  emptbl1 WHERE empId = '"+id+"'";
Query query = session.createNativeQuery(sql);
result = query.executeUpdate();
System.out.println("Rows deleted: " + result);
t.commit();  
session.close();
}
public void hqlDelete(String id)
{
	session = factory.openSession(); 
	t = session.beginTransaction();   
 Query query=session.createQuery("delete from Employee where id='"+id+"'");  
 result=query.executeUpdate();  
 System.out.println("Rows deleted: " + result);
 t.commit(); 
 session.close();
}

public void criteriaDelete(String id)
{
	session = factory.openSession(); 
	t = session.beginTransaction();   
	 Employee emp = (Employee ) session.createCriteria(Employee.class)
	            .add(Restrictions.eq("id", id)).uniqueResult();
	session.delete(emp);

	System.out.println("Rows deleted: " + result);
	 t.commit(); 
	 session.close();
	
}
protected void finalize()
{
   factory.close();  
}

}
