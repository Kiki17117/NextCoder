package com.example.NextCoder.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
/**
 * ホーム画面コントローラー
 */
public class HomeController {

	/**
	 * 初期表示
	 * @return ホーム画面
	 */
	@GetMapping("/home")
    public String showHomePage() {
		return "home";
    }
}
