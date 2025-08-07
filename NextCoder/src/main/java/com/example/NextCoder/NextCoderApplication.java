package com.example.NextCoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NextCoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextCoderApplication.class, args);
	}

}
