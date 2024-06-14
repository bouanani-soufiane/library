package com.library.mapper.implementation;

import com.library.entities.Book;
import com.library.mapper.interfaces.Mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements Mapper<Book> {

    @Override
    public Book toObject ( ResultSet res ) throws SQLException {
        Book book = new Book();
        book.setISBN(res.getLong("ISBN"));
        book.setTitle(res.getString("TITLE"));
        book.setAuthor(res.getString("AUTHOR"));
        book.setQuantity(res.getInt("QUANTITY"));
        return book;

    }

    @Override
    public void toArray ( Book book, PreparedStatement preparedStatement ) {
        

    }
}
