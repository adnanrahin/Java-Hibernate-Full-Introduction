package com.hibernate.demo.entity.read.object.usingquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GenerateObjectUsingHibernateQuery {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().
                addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Student> getAllStudent =
                    session.createQuery("from Student s where s.lastName='prime'").getResultList();

            for (Student student : getAllStudent) System.out.println(student);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }

}
