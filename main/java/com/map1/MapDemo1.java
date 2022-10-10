package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo1 {
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		e1.setEid(101);
		e1.setName("Ramesh");
		
		e2.setEid(102);
		e2.setName("Rahul");
		
		p1.setPid(201);
		p1.setProjectName("LibraryManagementSystem");
		
		p2.setPid(202);
		p2.setProjectName("ChatBot");
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p2.setEmp(list1);
		
		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		
		session.save(p1);
		session.save(p2);
		
		txt.commit();
		session.close();
		factory.close();
	}

}
