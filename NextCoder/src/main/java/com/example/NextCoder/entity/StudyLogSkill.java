package com.example.NextCoder.entity;

import com.example.NextCoder.entity.id.StudyLogSkillId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyLogSkill {
	@EmbeddedId
	private StudyLogSkillId id;

	@ManyToOne
	@MapsId("studyLogId")
	@JoinColumn(name = "study_log_id")
	private StudyLog studyLog;

	@ManyToOne
	@MapsId("skillId")
	@JoinColumn(name = "skill_id")
	private Skill skill;

}
