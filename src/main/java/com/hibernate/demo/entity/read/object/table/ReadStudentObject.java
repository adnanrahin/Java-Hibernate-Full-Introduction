package com.hibernate.demo.entity.read.object.table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentObject {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Student student = session.get(Student.class, 4);

            System.out.println(student);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
