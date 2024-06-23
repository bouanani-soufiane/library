package com.library.dao.interfaces;

import com.library.entities.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudInterface<T> {

    List<T> getAll();
    T store(T t) throws SQLException;
    T update(T t);
    T delete(T t);

}