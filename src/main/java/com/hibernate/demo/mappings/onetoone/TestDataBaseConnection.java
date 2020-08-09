package com.hibernate.demo.mappings.onetoone;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDataBaseConnection {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {

            Connection mc = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection Established");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

}
