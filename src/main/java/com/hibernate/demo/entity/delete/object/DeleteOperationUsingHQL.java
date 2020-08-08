package com.hibernate.demo.entity.delete.object;

import com.hibernate.demo.entity.read.object.table.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOperationUsingHQL {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            /*Student student = session.get(Student.class, 2);
            session.delete(student);*/

            session.createQuery("delete FROM Student s WHERE s.lastName='prime'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
