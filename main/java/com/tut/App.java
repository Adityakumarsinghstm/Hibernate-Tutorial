package com.tut;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started..." );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        //Creating Student
        Student st= new Student();
       st.setId(102);
        st.setName("Rahul");
       st.setCity("Delhi");
        
       System.out.println(st);
       Session session =factory.openSession();
       
      Transaction tx = session.beginTransaction();
      
      session.save(st);
      tx.commit();
     
  
        
        session.close();
    }

	
}
