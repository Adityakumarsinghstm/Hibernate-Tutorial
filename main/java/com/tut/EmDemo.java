package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args)
	{
		 Configuration cfg= new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        
	        Student student1 = new Student();
	        student1.setId(101);
	        student1.setName("Ankit Tiwari");
	        student1.setCity("Delhi");
	        
	        Certificate certificate = new Certificate();
	        certificate.setCourse("Android");
	        certificate.setDuration("3 month");
	        
	        student1.setCerti(certificate);
	        
	        
	        Student student2 = new Student();
	        student2.setId(102);
	        student2.setName("Brajesh Tiwari");
	        student2.setCity("Lukhnow");
	        
	        Certificate certificate2 = new Certificate();
	        certificate2.setCourse("Hibernate");
	        certificate2.setDuration("2 month");
	        
	        student2.setCerti(certificate2);
	        
	        Session s = factory.openSession();
	        Transaction tx = s.beginTransaction();
	        
	        //Saving object
	        s.save(student1);
	        s.save(student2);
	        
	       tx.commit();
	       s.close();
	        
		
		factory.close();
	}

}
