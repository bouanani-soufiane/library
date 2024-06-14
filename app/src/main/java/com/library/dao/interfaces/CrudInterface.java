package com.library.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudInterface<T> {
    List<T> getAll();
    Optional<T>  getById( long id);
    T store(T t);
    T update(T t);
    T delete(T t);


}
