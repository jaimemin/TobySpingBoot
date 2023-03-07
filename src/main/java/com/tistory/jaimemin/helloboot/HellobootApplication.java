package com.tistory.jaimemin.helloboot;

import com.tistory.jaimemin.config.MySpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class HellobootApplication {

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
