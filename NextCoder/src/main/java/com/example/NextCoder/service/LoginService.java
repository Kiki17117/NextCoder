package com.example.NextCoder.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.NextCoder.entity.UserEntity;
import com.example.NextCoder.repository.UserEntityRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面Service
 */
@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserEntityRepository repository;  // ユーザーデータのDBアクセス担当

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("loadUserByUsername called with: " + username);
        // DBからユーザー情報を取ってくる
        Optional<UserEntity> userOpt = repository.findByUsername(username);
        if (userOpt.isEmpty()) {
            // 見つからなかったら例外を投げて認証失敗を知らせる
            throw new UsernameNotFoundException("ユーザーが見つかりません: " + username);
        }

        UserEntity userEntity = userOpt.get();

        // Spring Security のUserオブジェクトを作る（認証処理に使われる）
        return User.withUsername(userEntity.getUsername())
                   .password(userEntity.getPassword())  // DBのハッシュ化済みパスワードを設定
                   .roles("USER")  // 権限（ロール）を付与
                   .build();
    }
}

