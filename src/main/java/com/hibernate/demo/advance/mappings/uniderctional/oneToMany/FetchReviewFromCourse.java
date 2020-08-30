package com.hibernate.demo.advance.mappings.uniderctional.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FetchReviewFromCourse {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate4.cfg.xml")
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Review> reviews = session.get(Course.class, 10).getReviews();

            System.out.println(reviews);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
