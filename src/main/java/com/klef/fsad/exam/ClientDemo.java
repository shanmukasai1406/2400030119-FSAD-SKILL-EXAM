package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Payment.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // Insert 1 record
        Payment p = new Payment(101,"Sai","2026-03-12","Completed",5000);

        session.persist(p);

        tx.commit();

        System.out.println("1 Record Inserted Successfully");

        session.close();
        sf.close();
    }
}