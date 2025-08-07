package com.example.NextCoder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.NextCoder.entity.StudyLog;
import com.example.NextCoder.entity.StudyLogSkill;
import com.example.NextCoder.entity.id.StudyLogSkillId;
import com.example.NextCoder.entity.Skill;
import com.example.NextCoder.repository.SkillRepository;
import com.example.NextCoder.repository.StudyLogRepository;
import com.example.NextCoder.repository.StudyLogSkillRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyLogSkillService {

	private final StudyLogSkillRepository studyLogSkillRepository;
	private final StudyLogRepository studyLogRepository;
	private final SkillRepository skillRepository;

	public void addSkillToStudyLog(Long studyLogId, Long skillId) {
		StudyLog studyLog = studyLogRepository.findById(studyLogId)
				.orElseThrow(() -> new IllegalArgumentException("StudyLog not found"));

		Skill skill = skillRepository.findById(skillId)
				.orElseThrow(() -> new IllegalArgumentException("Skill not found"));

		StudyLogSkill studyLogSkill = StudyLogSkill.builder()
				.id(new StudyLogSkillId(studyLogId, skillId))
				.studyLog(studyLog)
				.skill(skill)
				.build();

		studyLogSkillRepository.save(studyLogSkill);


	}

	public void addSkillsToStudyLog(Long studyLogId, List<Long> skillIds) {
	    StudyLog studyLog = studyLogRepository.findById(studyLogId)
	            .orElseThrow(() -> new IllegalArgumentException("StudyLog not found"));

	    for (Long skillId : skillIds) {
	        Skill skill = skillRepository.findById(skillId)
	                .orElseThrow(() -> new IllegalArgumentException("Skill not found"));

	        StudyLogSkill studyLogSkill = StudyLogSkill.builder()
	                .id(new StudyLogSkillId(studyLogId, skillId))
	                .studyLog(studyLog)
	                .skill(skill)
	                .build();

	        studyLogSkillRepository.save(studyLogSkill);
	    }
	}

}
