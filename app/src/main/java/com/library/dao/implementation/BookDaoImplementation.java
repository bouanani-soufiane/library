package com.library.dao.implementation;

import com.library.dao.interfaces.BookDaoInterface;
import com.library.entities.Book;

import java.util.List;
import java.util.Optional;

public class BookDaoImplementation implements BookDaoInterface {
    @Override
    public List<Book> getAll () {
        return List.of();
    }

    @Override
    public Optional<Book> getById ( long id ) {
        return null;
    }

    @Override
    public Book store ( Book book ) {
        return null;
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
