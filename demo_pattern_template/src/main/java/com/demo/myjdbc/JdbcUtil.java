package com.demo.myjdbc;

import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JdbcUtil {
    public static DataSource getDatasource(){
        try {
            OracleDataSource oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL("jdbc:oracle:thin:@192.168.66.166:1521:orcl");
            oracleDataSource.setUser("h_publish");
            oracleDataSource.setPassword("huawei123");
            return oracleDataSource;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
