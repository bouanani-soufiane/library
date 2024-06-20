package com.library.dao.implementation;

import com.library.dao.interfaces.BookCopyDaoInterface;
import com.library.entities.BookCopy;

import java.util.List;
import java.util.Optional;

public class BookCopyDaoImplementation implements BookCopyDaoInterface {
    @Override
    public List<BookCopy> getAll () {
        return List.of();
    }

    @Override
    public BookCopy getByISBN ( long isbn ) {
        return null;
    }

    @Override
    public Optional<BookCopy> getById ( long id ) {
        return Optional.empty();
    }

    @Override
    public BookCopy store ( BookCopy bookCopy ) {
        return null;

    }
    @Override
    public BookCopy update ( BookCopy bookCopy ) {
        return null;
    }

    @Override
    public BookCopy delete ( BookCopy bookCopy ) {
        return null;
    }
}
