package com.example.NextCoder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報テーブル Entity
 */
@Entity
@Table(name = "user_info")
@Data
public class UserEntity {

	/** ユーザーID*/
	@Id
	@Column(name = "user_id")
	private String userId;

	/** パスワード*/
	private String password;
}
