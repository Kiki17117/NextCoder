package com.example.NextCoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.NextCoder.service.LoginService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final LoginService loginService;
    /**
     * ユーザー情報の取得にLoginServiceを設定する
     * @param loginService
     */
    public SecurityConfig(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * AuthenticationManager(ユーザー認証をおこなうクラス）をBean登録
     * @param authConfig
     * @return
     * @throws Exception
     */
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            	// CSSファイルやJSファイルを読み込めるようにしておく
                .requestMatchers("/signup","/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            )
            .userDetailsService(loginService)
            .formLogin(form -> form
            	.loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
            );

        return http.build();
    }
}
