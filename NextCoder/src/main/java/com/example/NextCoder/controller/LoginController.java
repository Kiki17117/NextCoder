package com.example.NextCoder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.NextCoder.entity.UserEntity;
import com.example.NextCoder.form.SignupForm;
import com.example.NextCoder.repository.UserEntityRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final UserEntityRepository userEntityRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String registerPage(Model model) {
        model.addAttribute("signupForm", new SignupForm()); // フォーム初期化
        System.out.println("サインイン画面");
        return "signup";
    }

    @PostMapping("/signup")  // GETとPOSTを同じパスに統一
    public String register(@ModelAttribute SignupForm form, Model model) {
        if (userEntityRepository.existsByUsername(form.getUsername())) {
            model.addAttribute("errorMsg", "このユーザーIDはすでに使用されています");
            return "signup";  // エラーページはsignup.htmlに戻す
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(form.getUsername());  // フィールド名に合わせる（UserEntity側と合わせてください）
        userEntity.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));

        userEntityRepository.save(userEntity);

        return "redirect:/login?registerSuccess";
    }
}
