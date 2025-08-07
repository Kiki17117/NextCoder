package com.example.NextCoder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.NextCoder.entity.Skill;
import com.example.NextCoder.repository.SkillRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SkillService {

	private final SkillRepository skillRepository;

	public List<Skill> getAllSkills(){
		return skillRepository.findAll();
	}
}
