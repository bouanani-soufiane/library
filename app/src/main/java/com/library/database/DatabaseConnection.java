package com.library.database;

import com.library.utils.Print;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection instance ;
    private Connection connection ;
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USERNAME = "soufiane";
    private static final String PASSWORD = "1234";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private DatabaseConnection() throws SQLException{
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Print.log("Connection established.");
        }catch (ClassNotFoundException e){
            Print.log("Database Connection Creation Failed : " + e.getMessage());
        }
    }


    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public Connection getConnection (){
        return connection;
    }
    public static boolean closeConnection() {
        if (instance == null) {
            return false;
        }

        try {
            instance.getConnection().close();
            instance = null;
            return true;
        } catch (SQLException e) {
            Print.log(e.toString());
            return false;
        }
    }

}
