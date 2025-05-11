// Alisa Steensen
// Module 10.2

package com.example.javafxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


import java.sql.*;

public class FXMLLogic {

    // To connect to the sql file
    private final SQLConnection sqlConnection = new SQLConnection();
    private final Connection con = sqlConnection.getConnection();
    private final Statement stmt = sqlConnection.getStatement();

    // All the FMXL requirements
    @FXML
    private TextField insertname;
    @FXML
    private TextField insertlastname;
    @FXML
    private TextField insertteam;

    @FXML
    public void addToSQL(ActionEvent event) { // Logic for adding information into SQL database

        String sql = "INSERT INTO fans (first_name, last_name, favorite_team) VALUES ('" + insertname.getText() + "', '" + insertlastname.getText() + "', '" + insertteam.getText() + "')";

        try {
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows + " fan added.");
        } catch (java.lang.Exception ex){

            ex.printStackTrace();
        }
    }

    @FXML
    public void displayAllSQL(ActionEvent event) { // Logic for display all button to display all info in SQL database

            try (ResultSet rs = stmt.executeQuery("SELECT * FROM fans")) {
                System.out.println("Displaying all fans:");

                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ": " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("favorite_team"));
                }
            } catch (java.lang.Exception ex){

                ex.printStackTrace();
            }
    }
}
