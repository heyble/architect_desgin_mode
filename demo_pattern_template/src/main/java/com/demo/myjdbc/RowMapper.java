package com.demo.myjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface  RowMapper<T> {
    List<T> parseResult(ResultSet resultSet) throws SQLException;
}
