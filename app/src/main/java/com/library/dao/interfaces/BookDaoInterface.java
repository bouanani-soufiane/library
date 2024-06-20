package com.library.dao.interfaces;

import com.library.entities.Book;

import java.util.Optional;

public interface BookDaoInterface extends CrudInterface <Book>{

    Book getByISBN ( long isbn );
}
