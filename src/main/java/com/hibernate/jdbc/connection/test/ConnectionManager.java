package com.hibernate.jdbc.connection.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String userId = "hbstudent";
        String pass = "hbstudent";


        try {

            Connection myConnection = DriverManager.getConnection(jdbcUrl, userId, pass);
            System.out.println("Connection is Successful");

        } catch (Exception e) {

            System.out.println(e);

        }

    }


}
