package com.hibernate.demo.mappings.OneToOne.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveInstructorInDataBase {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Instructor instructor = new Instructor("Vector", "Prime", "vectorprime@email.com");

            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/vectorprime", "Eating");

            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
