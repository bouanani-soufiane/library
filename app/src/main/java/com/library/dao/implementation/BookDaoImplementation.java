package com.library.dao.implementation;

import com.library.dao.interfaces.BookDaoInterface;
import com.library.database.DatabaseConnection;
import com.library.entities.Book;
import com.library.mapper.implementation.BookMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDaoImplementation implements BookDaoInterface {
    private Connection connection;
    ResultSet result ;
    List<Book> bookList = new ArrayList<>();
    private final BookMapper bookMapper;
    public BookDaoImplementation() {
        bookMapper = new BookMapper();
        try{
             this.connection = DatabaseConnection.getInstance().getConnection();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public List<Book> getAll () {
        return List.of();
    }

    @Override
    public List<Book> getByISBN ( long isbn ) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE ISBN = ?");
            preparedStatement.setLong(1, isbn);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                bookList.add(bookMapper.toObject(result));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return bookList;


    }

    @Override
    public List<Book> getByAuthor ( String author ) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE AUTHOR = ?");
            preparedStatement.setString(1, author);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                bookList.add(bookMapper.toObject(result));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }


    @Override
    public Book store ( Book book ) throws SQLException {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book(ISBN,TITRE , AUTHOR, QUANTITY) VALUES (?, ?, ? ,?)");
            bookMapper.preparedStatement(book, preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return book;

    }

    @Override
    public Book update ( Book book ) {
        return null;
    }

    @Override
    public Book delete ( Book book ) {

        return book;
    }
}
