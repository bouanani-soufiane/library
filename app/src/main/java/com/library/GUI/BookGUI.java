package com.library.GUI;

import java.util.Scanner;

public class BookGUI {
    public void ManageBookMenu( Scanner scanner ){
        int choice;
        System.out.println("");
        System.out.println("                    Book Management Menu:");
        System.out.println("");

        System.out.println("                    |1|  => Find Book (ISBN, Author, Title)  :");
        System.out.println("                    |2|  => Add New Book :");
        System.out.println("                    |3|  => Edit Existing book :");
        System.out.println("                    |4|  => Delete Existing book :");

        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("here is it");
                break;
            case 2:
                System.out.println("add");
                break;
            case 3:
                System.out.println("edit");
                break;
            default:
                System.out.println("delete");
                break;
        }

    }
}
