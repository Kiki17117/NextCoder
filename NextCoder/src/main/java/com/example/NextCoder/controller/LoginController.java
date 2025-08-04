package com.example.NextCoder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.NextCoder.form.LoginForm;
import com.example.NextCoder.service.LoginService;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面コントローラー
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

	/** ログイン画面サービス*/
	private final LoginService service;

	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;

	/**
	 * 初期表示
	 * @param model
	 * @return　ログイン画面
	 */
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		model.addAttribute("loginForm",new LoginForm());
		return "login";
	}

	/**
	 * ログイン
	 * IDとパスの正誤判定をし、ホーム画面orエラーメッセージ
	 * @param model
	 * @param form　入力情報
	 * @return　ホーム画面
	 */
	@PostMapping("/login")
	public String login(Model model,LoginForm form) {
		var userInfo = service.searchUserById(form.getUserID());
		var encordedPassword = passwordEncoder.encode(form.getPassword());
		var isCorrectUserAuth = userInfo.isPresent()
				&& passwordEncoder.matches(form.getPassword(),userInfo.get().getPassword());
		if(isCorrectUserAuth) {
			return "redirect:/home";
		} else {
			model.addAttribute("errorMsg","ログインIDとパスワードの組み合わせが間違っています。");
			return "login";
		}
	}
}
