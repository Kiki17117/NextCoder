package com.example.NextCoder.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
	@RequestMapping("/")
    public String showIndexPage() {
		return "index";
    }
}
