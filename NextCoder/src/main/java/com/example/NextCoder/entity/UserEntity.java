package com.example.NextCoder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザー情報テーブル Entity
 */
@Entity
@Table(name = "user_info")
@NoArgsConstructor
@Data
public class UserEntity {

	/** 主キー（内部ID） */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** ユーザー名*/
	@Column(name = "username", nullable = false,
			unique = true, length = 50)
	private String username;

	/** パスワード*/
	@Column(name = "password", nullable = false,
			length = 255)
	private String password;
}
