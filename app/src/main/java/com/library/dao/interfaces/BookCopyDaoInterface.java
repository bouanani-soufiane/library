package com.library.dao.interfaces;

import com.library.entities.BookCopy;

import java.util.Optional;

public interface BookCopyDaoInterface extends CrudInterface<BookCopy> {
    Optional<BookCopy> getById ( long id );
}
