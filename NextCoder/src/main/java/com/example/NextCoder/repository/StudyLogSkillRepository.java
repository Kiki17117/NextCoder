package com.example.NextCoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NextCoder.entity.StudyLogSkill;
import com.example.NextCoder.entity.id.StudyLogSkillId;

public interface StudyLogSkillRepository extends JpaRepository<StudyLogSkill,StudyLogSkillId>{

}
