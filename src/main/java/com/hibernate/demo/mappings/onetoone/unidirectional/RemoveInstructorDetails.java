package com.hibernate.demo.mappings.onetoone.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RemoveInstructorDetails {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int instructorDetailId = 3;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);

            session.delete(instructorDetail);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
