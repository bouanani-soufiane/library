package com.library.dao.interfaces;

import com.library.entities.Book;

import java.util.Optional;

public interface BookDaoInterface extends CrudInterface <Book>{

    Optional<Book> getByISBN ( long isbn );
}
