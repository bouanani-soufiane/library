package com.library.mapper.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper <T> {
    T toObject( ResultSet res ) throws SQLException;
    void preparedStatement( T object , PreparedStatement preparedStatement );

}
