package com.example.NextCoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NextCoder.entity.UserInfo;

/**
 * ユーザー情報テーブルDAO
 */
@Repository
public interface UserInfoRepository extends JpaRepository <UserInfo,String>{

}
