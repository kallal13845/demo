package com.example.demo.service;

import java.util.Map;

public interface MysqlService {
    Map<String, Object> extractDDLMapForTable(String tableName);
}
