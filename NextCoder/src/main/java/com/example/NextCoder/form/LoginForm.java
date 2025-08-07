package com.example.NextCoder.form;

import lombok.Data;

/**
 * ログイン画面Form
 */
@Data
public class LoginForm {
	/** ユーザーID */
	private String Username;
	/** パスワード */
	private String password;
}
