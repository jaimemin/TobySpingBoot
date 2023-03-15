package com.tistory.jaimemin.helloboot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class HellobootApplication {

	private final JdbcTemplate jdbcTemplate;

	@PostConstruct
	void init() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello(name varchar(50) primary key, count int)");
	}

	@Bean
	ApplicationRunner applicationRunner(Environment environment) {
		return args -> {
			String name = environment.getProperty("my.name");

			System.out.println("my.name: " + name);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);
	}

}
