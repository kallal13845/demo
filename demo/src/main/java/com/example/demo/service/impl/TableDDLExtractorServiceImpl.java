package com.example.demo.service.impl;

import com.example.demo.service.TableDDLExtractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TableDDLExtractorServiceImpl implements TableDDLExtractorService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TableDDLExtractorServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Object>  extractDDLMapForTable(String tableName) {
        String query = "SHOW CREATE TABLE " + tableName;
        return jdbcTemplate.queryForMap(query);
    }
}
