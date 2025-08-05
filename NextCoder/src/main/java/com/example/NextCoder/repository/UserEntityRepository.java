package com.example.NextCoder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NextCoder.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
	Optional<UserEntity> findByUserId(String userId);
}