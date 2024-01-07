package com.example.demo.service.impl;

import com.example.demo.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MysqlServiceImpl implements MysqlService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MysqlServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Object>  extractDDLMapForTable(String tableName) {
        String query = "SHOW CREATE TABLE " + tableName;
        return jdbcTemplate.queryForMap(query);
    }
}
