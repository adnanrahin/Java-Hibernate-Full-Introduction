package com.hibernate.demo.mappings.OneToOne.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int instructorId = 2;

            Instructor instructor = session.get(Instructor.class, instructorId);

            System.out.println(instructor);

            session.delete(instructor);

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }

}
