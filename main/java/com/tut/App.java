package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
       // System.out.println(factory);
       // System.out.println(factory.isClosed());
        
        
        //Creating Address
        Address ad= new Address();
        ad.setStreet("Street1");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(82734.645);
        
        
        //Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/error.png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        //Creating Student
        
        Student st= new Student();
        st.setId(102);
        st.setName("Durgesh Tiwari");
        st.setCity("Lakhnow");
        
        System.out.println(st);
        
        
        
        Session session = factory.openSession();
        Transaction txt = session.beginTransaction();
        session.save(st);
        session.save(ad);
        
        txt.commit();
        
        
        session.close();
        System.out.println("done....");
    }
}
