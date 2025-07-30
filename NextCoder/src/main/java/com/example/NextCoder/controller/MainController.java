package com.example.NextCoder.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NextCoder.NextCoderApplication;

@SpringBootApplication
@RestController
public class MainController {
	
	@RequestMapping("/")
	String hello() {
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NextCoderApplication.class, args);
	}
}
