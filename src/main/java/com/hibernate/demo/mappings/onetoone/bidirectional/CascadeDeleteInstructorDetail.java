package com.hibernate.demo.mappings.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/// Delete Cascade will delete the associate instructor with InstructorDetail

public class CascadeDeleteInstructorDetail {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 4;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            session.delete(instructorDetail);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
