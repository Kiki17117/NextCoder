package com.example.NextCoder.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.NextCoder.entity.UserInfo;
import com.example.NextCoder.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面Service
 */
@Service
@RequiredArgsConstructor
public class LoginService {
	/** ユーザー情報テーブルDAO */
	private final UserInfoRepository repository;

	/**
	 * ユーザー情報テーブルキー検索
	 * @param userId ユーザーID
	 * @return ユーザー情報テーブルの検索結果（1件）
	 */
	public Optional<UserInfo> searchUserById(String userId){
		return repository.findById(userId);
	}
}
