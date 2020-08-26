package com.hibernate.demo.mappings.fetching.Lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HqlQueryToRetrieveInstructorCourse {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            /*
            *
            * In Hibernate LazyLoading does not allow to retrieve data after the session object is closed,
            * in a situation we can use Hibernate query to retrieve the data,
            * Hibernate Query Allow us to retrieve the data even after closing the session.
            *
            * */

            session.beginTransaction();

            int theId = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                            + "JOIN fetch i.courses " + "where i.id =: theInstructorId",
                    Instructor.class);

            query.setParameter("theInstructorId", theId);

            Instructor instructor = query.getSingleResult();

            System.out.println(instructor.getCourses());

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
