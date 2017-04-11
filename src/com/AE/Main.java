package com.AE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
//          before 4.0
//        Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/Production/Courses/Programs/JavaPrograms/TestDB/testjava.db");
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/Angel/git/TestDB/testjava.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT )");

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }


        }
}
