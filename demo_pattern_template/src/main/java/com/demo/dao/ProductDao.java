package com.demo.dao;

import com.demo.entity.Product;
import com.demo.myjdbc.JdbcTemplate;
import com.demo.myjdbc.JdbcUtil;
import com.demo.myjdbc.RowMapper;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDatasource());

    public List<?> findAll(){

        List<?> list = jdbcTemplate.excutor("select * from t_product", new RowMapper() {
            @Override
            public List parseResult(ResultSet resultSet) throws SQLException {
                List<Product> list = new ArrayList<>();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getLong("id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setCreateDate(resultSet.getDate("create_date"));
                    list.add(product);
                }
                return list;
            }
        }, null);
        return list;
    }
}
