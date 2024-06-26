package com.library.database;

import com.library.utils.Print;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection instance ;
    private Connection Conn ;
    private final String  url = "jdbc:mysql://localhost:3306/library";
    private final String  username = "soufiane";
    private final String  password = "1234";
    private final String  driver = "com.mysql.cj.jdbc.Driver";

    private DatabaseConnection() throws SQLException{
        try {
            Class.forName(driver);
            this.Conn = DriverManager.getConnection(url, username, password);

            Print.log("Connection established.");

        }catch (ClassNotFoundException e){
            Print.log("Database Connection Creation Failed : " + e.getMessage());
        }
    }
    public Connection getConnection (){
        return Conn;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DatabaseConnection();
        }else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public static boolean closeConnection(){

        if (instance ==null){
            return false;
        }else {
            try {
                instance.getConnection().close();
                instance = null;
                return true;
            } catch (SQLException e) {
                Print.log(e.toString());
            }
        }
        return false;
    }

}
