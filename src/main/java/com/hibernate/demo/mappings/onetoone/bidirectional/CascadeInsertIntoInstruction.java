package com.hibernate.demo.mappings.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CascadeInsertIntoInstruction {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = new Instructor("Ultra", "Magnus", "ultramagnus@email.com");

            InstructorDetail instructorDetail = new InstructorDetail("http://wwww.youtube.com/ultramagnus", "Sleeping");

            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);

            session.getTransaction().commit();

        } catch (Exception e) {
            session.close();
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }

    }

}
