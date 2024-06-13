package com.library;

import com.library.database.DatabaseConnection;
import com.library.utils.Print;
import java.sql.Connection;
import java.sql.SQLException;


public class App {
  public static void main ( String[] args ) {
    System.out.println( "Hello World!" );

    try {
      // Attempt to get a database connection
      DatabaseConnection dbConnection = DatabaseConnection.getInstance();
      Connection connection = dbConnection.getConnection();

      // Check if the connection is not null and open
      if (connection != null && !connection.isClosed()) {
        Print.log("Database connection is working.");
      } else {
        Print.log("Failed to establish database connection.");
      }
    } catch (SQLException e) {
      Print.log("Error: " + e.getMessage());
    }
  }

}
