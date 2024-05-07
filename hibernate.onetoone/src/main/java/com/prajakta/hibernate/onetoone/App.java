package com.prajakta.hibernate.onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prajakta.hibernate.entity.Passport;
import com.prajakta.hibernate.entity.Student;


public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = new Configuration()
    			.configure()
    			.addAnnotatedClass(Student.class)
    			.addAnnotatedClass(Passport.class)
    			.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	Transaction  transaction = session.getTransaction();
    	
    	
    	Passport passport = new Passport();
    	passport.setPassportNumber("AK892124");
    	
        Student student = new Student();
        student.setStudentName("Ayush");
        student.setCountry("USA");
        student.setPassport(passport);
        transaction.begin();
        session.persist(passport);
        session.persist(student);
        
        transaction.commit();
        
    }
}
