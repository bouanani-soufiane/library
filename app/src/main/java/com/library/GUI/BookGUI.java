package com.library.GUI;

import com.library.dao.implementation.BookDaoImplementation;
import com.library.dao.interfaces.BookDaoInterface;
import com.library.entities.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
                this.findByIsbn(scanner);
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
        scanner.nextLine();
        book.setISBN(ISBN);
        System.out.println("enter the Author :");
        String Author = scanner.nextLine();
        book.setAuthor(Author);
        System.out.println("enter the Title :");
        String Title = scanner.nextLine();
        book.setTitle(Title);
        System.out.println("enter the Quantity :");
        int Quantity = scanner.nextInt();
        book.setQuantity(Quantity);
        bookDao.store(book);
        return book;

    }

    public void findByIsbn(Scanner scanner) throws SQLException {
        BookDaoInterface bookDao = new BookDaoImplementation();
        System.out.println("enter the ISBN :");
        long ISBN = scanner.nextLong();
        scanner.nextLine();

        List<Book> books = bookDao.getByISBN(ISBN);
        if (books.isEmpty()) {
            System.out.println("No book found with ISBN: " + ISBN);
        } else {
            System.out.println("Found book(s):");
            for (Book book : books) {
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Quantity: " + book.getQuantity());
                System.out.println("-------------------------");
            }
        }
    }





    /* public List<Book> getAllBookByIsbn() throws SQLException {

        }
    */

}