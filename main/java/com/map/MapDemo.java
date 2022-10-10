package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
//		Question question = new Question();
//		question.setQuestionId(101);
//		question.setQuestion("What is java ? ");
//		
//		
//		Answer answer1 = new Answer();
//		answer1.setAnswerId(201);
//		answer1.setAnswer("java is a programming language.");
//		answer1.setQuestion(question);
//		
//		Answer answer2 = new Answer();
//		answer2.setAnswerId(202);
//		answer2.setAnswer("With the help of java we can build software.");
//		answer2.setQuestion(question);
//		
//		
//		Answer answer3 = new Answer();
//		answer3.setAnswerId(203);
//		answer3.setAnswer("java has different frameworks.");
//		answer3.setQuestion(question);
//		
//		
//		List<Answer> list = new ArrayList<Answer>();
//		list.add(answer1);
//		list.add(answer2);
//		list.add(answer3);
		
		Transaction txt = session.beginTransaction();
		
//		session.save(question);
//		session.save(answer1);
//		session.save(answer2);
//		session.save(answer3);
		
		
		Question q = (Question)session.get(Question.class, 101);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		
		System.out.println(q.getAnswers().size());
		
		
		txt.commit();
		session.close();
		factory.close();
	}

}
