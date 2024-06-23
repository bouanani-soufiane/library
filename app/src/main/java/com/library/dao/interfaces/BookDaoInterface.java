package com.library.dao.interfaces;

import com.library.entities.Book;
import pl.mjaron.etudes.Str;

import java.util.List;
import java.util.Optional;

public interface BookDaoInterface extends CrudInterface <Book>{
    List<Book> getByISBN ( long isbn );
    List<Book> getByAuthor ( String author );

}
