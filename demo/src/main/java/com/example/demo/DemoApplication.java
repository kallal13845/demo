package com.example.demo;

import com.example.demo.service.ClickhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.MysqlService;

import java.sql.Connection;
import java.util.Map;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private MysqlService mysqlService;

	@Autowired
	private ClickhouseService clickhouseService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String tableName = "mytable";
		Map<String, Object> ddl = mysqlService.extractDDLMapForTable(tableName);
		System.out.println("DDL for table " + tableName + ":\n" + ddl);



		try (Connection conn = clickhouseService.getConnection()) {
			System.out.println("Update Count: " + clickhouseService.createTable(conn));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
