package com.library.GUI;

import com.library.dao.implementation.BookDaoImplementation;
import com.library.dao.interfaces.BookDaoInterface;
import com.library.entities.Book;

import java.sql.SQLException;
import java.util.Scanner;

public class BookGUI {

    public void ManageBookMenu( Scanner scanner ) throws SQLException {
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
                this.AddBookMenu(scanner);
                break;
            case 3:
                System.out.println("edit");
                break;
            default:
                System.out.println("delete");
                break;
        }

    }

    public Book AddBookMenu( Scanner scanner ) throws SQLException {
        Book book = new Book();
        BookDaoInterface bookDao = new BookDaoImplementation();
        System.out.println("enter the ISBN :");
        long ISBN = scanner.nextLong();
        book.setISBN(ISBN);
        System.out.println("enter the Author :");
        String Author = scanner.next();
        book.setAuthor(Author);
        System.out.println("enter the Title :");
        String Title = scanner.next();
        book.setTitle(Title);
        System.out.println("enter the Quantity :");
        int Quantity = scanner.nextInt();
        book.setQuantity(Quantity);
        bookDao.store(book);

        return book;

    }

}