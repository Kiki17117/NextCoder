package com.example.NextCoder.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.NextCoder.NextCoderApplication;

@SpringBootApplication
@Controller
public class MainController {

	@GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "こんにちは、Spring MVC！");
        return "hello"; // → resources/templates/hello.html を表示
    }

	public static void main(String[] args) {
		SpringApplication.run(NextCoderApplication.class, args);
	}
}
