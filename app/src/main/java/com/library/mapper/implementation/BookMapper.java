package com.library.mapper.implementation;

import com.library.entities.Book;
import com.library.mapper.interfaces.Mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements Mapper<Book> {

    @Override
    public Book toObject (  ResultSet res ) throws SQLException {
        Book book = new Book();
        try {
            book.setISBN(res.getLong("ISBN"));
            book.setTitle(res.getString("TITRE"));
            book.setAuthor(res.getString("AUTHOR"));
            book.setQuantity(res.getInt("QUANTITY"));
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw e;
        }
        return book;

    }

    @Override
    public void preparedStatement (  Book book,  PreparedStatement preparedStatement ) {
        try {
            preparedStatement.setLong(1,book.getISBN());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setInt(4,book.getQuantity());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
