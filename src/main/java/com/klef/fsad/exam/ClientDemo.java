package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Payment.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // Insert Record
        Payment p = new Payment();
        p.setId(101);
        p.setName("Sai");
        p.setDate("2026-03-12");
        p.setStatus("Completed");
        p.setAmount(5000);

        session.persist(p);

        tx.commit();

        System.out.println("Record Inserted");

        // Delete using HQL Named Parameter
        session.beginTransaction();

        Query q = session.createQuery("delete from Payment where id = :pid");
        q.setParameter("pid", 101);

        int result = q.executeUpdate();

        session.getTransaction().commit();

        System.out.println(result + " Record Deleted");

        session.close();
        sf.close();
    }
}