/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 */import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

  Connection con;
  Statement stmt;

  public CreateTable() {
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");

          String url = "jdbc:mysql://localhost:3306/student33db?user=student33&password=pass";
          con = DriverManager.getConnection(url);
          stmt = con.createStatement();
          System.out.println("Connected to database successfully!");
      } catch (Exception e) {
          System.out.println("Error connecting to database:");
          e.printStackTrace(); // <--- Shows the real error
          System.exit(0);
      }

      try {
          stmt.executeUpdate("DROP TABLE IF EXISTS address33");
          System.out.println("Table address33 dropped (if it existed)");
      } catch (SQLException e) {
          System.out.println("Error dropping table:");
          e.printStackTrace();
      }

      try {
          stmt.executeUpdate("CREATE TABLE address33(" +
                             "ID int PRIMARY KEY, " +
                             "LASTNAME varchar(40), " +
                             "FIRSTNAME varchar(40), " +
                             "STREET varchar(40), " +
                             "CITY varchar(40), " +
                             "STATE varchar(40), " +
                             "ZIP varchar(40))");
          System.out.println("Table address33 created successfully!");
      } catch (SQLException e) {
          System.out.println("Error creating table:");
          e.printStackTrace();
      }

      try {
          stmt.close();
          con.close();
          System.out.println("Database connection closed.");
      } catch (SQLException e) {
          System.out.println("Error closing connection:");
          e.printStackTrace();
      }
  }

  public static void main(String[] args) {
      new CreateTable();
  }
}
