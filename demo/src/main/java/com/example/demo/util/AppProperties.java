package com.example.demo.util;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@Data
public class AppProperties {

    @Value("${clickhouse.datasource.url}")
    private String chUrl;

    @Value("${clickhouse.datasource.username}")
    private String chUsername;

    @Value("${clickhouse.datasource.password}")
    private String chPassword;


}
