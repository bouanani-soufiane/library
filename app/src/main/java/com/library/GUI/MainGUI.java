package com.library.GUI;

import java.util.Scanner;


public class MainGUI {

    private final BookGUI bookGUI;

    public MainGUI(BookGUI bookGUI) {
        this.bookGUI = bookGUI;
    }
    public void displayOptions(Scanner scanner) {
        int choice;
        do {

            System.out.println();
            System.out.println("                    Please choose one of the following options:");
            System.out.println();

            System.out.println("                    |1|  => Manager Books :");
            System.out.println("                    |2|  => Manager Members :");
            System.out.println("                    |3|  => Manager Loan :");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookGUI.ManageBookMenu(scanner);
                    break;
                case 2:
                    System.out.println("member");
                    break;
                case 3:
                    System.out.println("loan");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice > 0 && choice < 4);
    }
}
