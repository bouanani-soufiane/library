package com.library.GUI;

import com.library.dao.implementation.BookDaoImplementation;
import com.library.dao.interfaces.BookDaoInterface;
import com.library.entities.Book;
import com.library.utils.Print;

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
                this.findBook(scanner);
                break;
            case 2:
                this.AddBookMenu(scanner);
                break;
            case 3:
                this.updateBook(scanner);
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

    public Book updateBook( Scanner scanner ) throws SQLException {
        Book book = new Book();
        BookDaoInterface bookDao = new BookDaoImplementation();
        System.out.println("enter the ISBN of the book you want to update :");
        long ISBN = scanner.nextLong();
        scanner.nextLine();
        book.setISBN(ISBN);
        System.out.println("enter the new Author :");
        String Author = scanner.nextLine();
        book.setAuthor(Author);
        System.out.println("enter the new Title :");
        String Title = scanner.nextLine();
        book.setTitle(Title);
        System.out.println("enter the new Quantity :");
        int Quantity = scanner.nextInt();
        book.setQuantity(Quantity);
        bookDao.update(book);
        return book;
    }




    public void findBook ( Scanner scanner ) throws SQLException {
        System.out.println("find book by : ");
        System.out.println("1 - ISBN");
        System.out.println("2 - Author");
        System.out.println("3 - Title");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                this.findByIsbn(scanner);
                break;
            case 2:
                this.findByAuthor(scanner);
                break;
        }
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

    public void findByAuthor(Scanner scanner) throws SQLException {
        BookDaoInterface bookDao = new BookDaoImplementation();
        System.out.println("enter the Author name :");
        String author = Print.readString("Author" ,scanner);
        System.out.println("hada howa : " + author);

        List<Book>books = bookDao.getByAuthor(author);

        if (books.isEmpty()) {
            System.out.println("No book found with Author: " + author);
        }else {
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



}