package com.AE;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
//          before 4.0
//        Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/Production/Courses/Programs/JavaPrograms/TestDB/testjava.db");
        // try with resources automatically closes
//        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/Angel/git/TestDB/testjava.db");
//             Statement statement = conn.createStatement())
//        { statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT )");
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/Angel/git/TestDB/testjava.db");
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS" +
                    " contacts (name TEXT, phone INTEGER, email TEXT )");
//            statement.execute("INSERT INTO contacts (name, phone, email)"+
//            "VALUES('Joe', 45632, 'joe@anyemail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)"+
//                    "VALUES('Jane', 2345632, 'jane@anyemail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)"+
//                    "VALUES('Pepe', 2145632, 'pepe@anyemail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)"+
//                    "VALUES('Juanita', 5645632, 'juanita@anyemail.com')");
//            statement.execute("UPDATE contacts SET phone=5566789 " +
//                    " WHERE name='Jane'");
//            statement.execute("DELETE  FROM contacts WHERE name='Joe'");
            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while(results.next()){
                System.out.println(results.getString("name") + " " +
                results.getInt("phone")
                        + " " + results.getString("email"));
            }
            results.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }


    }
}
