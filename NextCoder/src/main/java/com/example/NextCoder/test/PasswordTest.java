package com.example.NextCoder.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        String rawPassword = "pwd";
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // 新しいハッシュ作成
        String newEncoded = encoder.encode(rawPassword);
        System.out.println("Encoded password: " + newEncoded);

        // ちゃんと一致するか確認
        boolean matches = encoder.matches(rawPassword, newEncoded);
        System.out.println("Password matches? " + matches);
    }
}
