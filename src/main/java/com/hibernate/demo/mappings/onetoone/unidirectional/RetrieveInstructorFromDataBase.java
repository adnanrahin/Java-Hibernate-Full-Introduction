package com.hibernate.demo.mappings.onetoone.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RetrieveInstructorFromDataBase {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Instructor> allInstructors = session.createQuery("from Instructor I WHERE I.id < 3").getResultList();

            System.out.println(allInstructors);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
