package com.example.demo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public interface ClickhouseService {


    Connection getConnection() throws SQLException;
    int createTable(Connection conn) throws SQLException;

}
