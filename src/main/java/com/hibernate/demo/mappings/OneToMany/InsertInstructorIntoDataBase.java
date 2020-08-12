package com.hibernate.demo.mappings.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertInstructorIntoDataBase {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = new Instructor("Rodimus", "Prime", "rodimusprime@email.com");

            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/rodimusprime", "Being Dick");

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
