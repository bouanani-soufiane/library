package com.library;

import com.library.GUI.BookGUI;
import com.library.GUI.MainGUI;

import java.sql.SQLException;
import java.util.Scanner;


public class App {

  public static void main ( String[] args ) throws SQLException {

    MainGUI mainGUI = new MainGUI(new BookGUI());
    Scanner scanner = new Scanner(System.in);
    System.out.println("####################################################################################");
    System.out.println("#                   Hello And Welcome To Book Library Management                   #");
    System.out.println("####################################################################################");
    mainGUI.displayOptions(scanner);

  }
}
