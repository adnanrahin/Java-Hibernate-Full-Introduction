package com.hibernate.demo.mappings.OneToOne.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEntity {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 3);

            System.out.println(instructor);

            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/megatron", "Flying");

            instructor.setInstructorDetail(instructorDetail);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
