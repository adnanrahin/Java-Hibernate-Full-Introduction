package com.hibernate.demo.advance.mappings.uniderctional.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertReview {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate4.cfg.xml")
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = new Course("Image Processing and Machine Learning");
            course.add(new Review("It was Great Class."));
            course.add(new Review("It's not that bad."));
            course.add(new Review("Okay for me."));
            session.save(course);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
