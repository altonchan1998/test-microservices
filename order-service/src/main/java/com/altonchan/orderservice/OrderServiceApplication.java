package com.altonchan.orderservice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
//@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
		return Server.createTcpServer(
				"-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}

	@PostConstruct
	private void initDb() {
		String sqlStatements[] = {
				"drop table employees if exists",
				"create table employees(id serial,first_name varchar(255),last_name varchar(255))",
				"insert into employees(first_name, last_name) values('Eugen','Paraschiv')",
				"insert into employees(first_name, last_name) values('Scott','Tiger')"
		};

		Arrays.asList(sqlStatements).forEach(sql -> {
			jdbcTemplate.execute(sql);
		});
	}
}
