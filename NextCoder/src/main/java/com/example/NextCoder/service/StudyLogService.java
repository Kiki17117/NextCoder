package com.example.NextCoder.service;

import org.springframework.stereotype.Service;

import com.example.NextCoder.entity.Skill;
import com.example.NextCoder.entity.StudyLog;
import com.example.NextCoder.entity.StudyLogSkill;
import com.example.NextCoder.entity.id.StudyLogSkillId;
import com.example.NextCoder.form.StudyLogForm;
import com.example.NextCoder.repository.SkillRepository;
import com.example.NextCoder.repository.StudyLogRepository;
import com.example.NextCoder.repository.StudyLogSkillRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyLogService {

	private final StudyLogRepository studyLogRepository;
	private final SkillRepository skillRepository;
	private final StudyLogSkillRepository studyLogSkillRepository;

	@Transactional
	public StudyLog save(StudyLogForm studyLogForm) {
		StudyLog studyLog = StudyLog.builder()
				.description(studyLogForm.getDescription())
				.studyTimeMinutes(studyLogForm.getStudyTimeMinutes())
				.build();
		StudyLog savedLog = studyLogRepository.save(studyLog);

		if(studyLogForm.getSkillIds() != null && !studyLogForm.getSkillIds().isEmpty()) {
			for(Long skillId : studyLogForm.getSkillIds()) {
				Skill skill = skillRepository.findById(skillId)
					.orElseThrow(() -> new IllegalArgumentException("Skill not found: id=" +skillId));
				StudyLogSkill studyLogSkill = StudyLogSkill.builder()
					.id(new StudyLogSkillId(savedLog.getId(), skill.getId()))
					.studyLog(savedLog)
					.skill(skill)
					.build();

				studyLogSkillRepository.save(studyLogSkill);
			}
		}
		return savedLog;
	}


}
