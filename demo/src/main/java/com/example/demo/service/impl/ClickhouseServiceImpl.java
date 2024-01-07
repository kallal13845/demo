package com.example.demo.service.impl;

import com.example.demo.service.ClickhouseService;
import com.example.demo.util.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Service
public class ClickhouseServiceImpl implements ClickhouseService {


    static final String TABLE_NAME = "jdbc_example_basic";

    @Autowired
    AppProperties appProperties;


    @Autowired
    public ClickhouseServiceImpl() {
    }

    @Override
    public Connection getConnection() throws SQLException {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(appProperties.getChUrl(), appProperties.getChUsername(),appProperties.getChPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public int createTable(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            // multi-statement query is supported by default
            // session will be created automatically during execution
            stmt.execute(String.format(
                    "create table %1$s(a String, b Nullable(String)) engine=Memory",
                    TABLE_NAME));
            return stmt.getUpdateCount();
        }
    }


}
