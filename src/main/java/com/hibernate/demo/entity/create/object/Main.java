package com.hibernate.demo.entity.create.object;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("optimus", "prime", "optimusprime@email.com");
            Student student2 = new Student("megatron", "beast", "megatron@email.com");

            session.beginTransaction();

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
