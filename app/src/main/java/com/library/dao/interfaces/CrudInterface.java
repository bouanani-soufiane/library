package com.library.dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudInterface<T> {

    List<T> getAll();
    Optional<T>  getById( long id);
    T store(T t) throws SQLException;
    T update(T t);
    T delete(T t);

}
