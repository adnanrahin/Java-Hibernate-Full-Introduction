package com.hibernate.demo.entity.update.object;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateOperationUsingHibernate {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        try {

            int studentId = 1;
            Session session = sessionFactory.getCurrentSession();
            /*session.beginTransaction();
            Student student = session.get(Student.class, studentId);

            student.setEmail("vectorprime@gmail.com");
*/
            //session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.
                    createQuery("update Student s set email='optimusprime@gmail.com' where s.firstName='optimus'").
                    executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
