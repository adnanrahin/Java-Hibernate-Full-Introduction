package com.hibernate.demo.mappings.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Instructor instructor = new Instructor("Optimus", "Prime", "optimusprime@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/prime",
                    "Fighting With Megatron");
            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);

            session.getTransaction().commit();

        } catch (Exception e) {
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
