package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
	public static void main(String[] args)
	{
		//Practical of Hibernate Object States
		//Transient
		//Persistent
		//Detached
		//Removed
		System.out.println("Example:");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Creating the object of Student
		Student student = new Student();
		student.setId(201);
		student.setName("Ravi");
		student.setCity("Bombay");
		student.setCerti(new Certificate("Hibernate","3 month"));
		//Student is now in Transient State
		
		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
	    session.save(student);
	    //Student is now in Persistent Object - session,database;
	    student.setName("jhon");
		txt.commit();
		session.close();
		//Student is now in Detached State -
		
		student.setName("sachin");
		System.out.println(student);
		
		factory.close();
	}

}
