package com.hibernate.demo.entity.update.object;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateOperationUsingHibernate {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        try {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            

            session.getTransaction().commit();

        } finally {

        }

    }

}
