package com.example.springpersistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringpersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringpersistenceApplication.class, args);
	}

}
