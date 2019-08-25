package com.demo.myjdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> excutor(String sql,RowMapper rowMapper, Object[] args) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        List<?> result = null;
        try {
            // 获取链接
            connection = getConnection();

            // 获得预编译对象
            statement = getPreparedStatement(connection, sql, args);

            // 执行并得到结果集
            resultSet = statement.executeQuery();

            // 解析结果集
            result = parse(rowMapper,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭语句集
            try {
                closePreparedStatement(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 关闭结果集
            try {
                closeResultSet(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 关闭链接
            try {
                closeConn(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }
    private void closePreparedStatement(PreparedStatement statement) throws SQLException {
        statement.close();
    }
    private void closeConn(Connection conn) throws SQLException {
        conn.close();
    }

    private PreparedStatement getPreparedStatement(Connection connection, String sql, Object[] args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        if (args != null){
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i,args[i]);
            }
        }
        return statement;
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private List<?> parse(RowMapper rowMapper, ResultSet resultSet) throws SQLException {
        return rowMapper.parseResult(resultSet);
    }
}
