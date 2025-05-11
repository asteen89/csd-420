// Alisa Steensen Module 10.2

package com.example.javafxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLConnection {
    Connection con;
    Statement stmt;

    // Constructor to initialize the connection
    public SQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/databasedb?user=student1&password=pass";
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            System.out.println("Connected to database successfully!");
        } catch (Exception e) {
            System.out.println("Error connecting to database:");
            e.printStackTrace(); // Shows the real error
            System.exit(0);
        }
    }

    public Connection getConnection() {
        return con;
    }
    public Statement getStatement() {
        return stmt;
    }
}
