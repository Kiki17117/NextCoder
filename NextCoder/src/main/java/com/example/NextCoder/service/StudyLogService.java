package com.example.NextCoder.service;

import java.util.List;

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

	/**
	 * 学習記録と紐づくスキル情報を一括で保存するメソッド
	 *
	 * @param studyLogForm フォームから受け取った学習内容・勉強時間・スキルIDリストなどの情報
	 * @return 保存したStudyLogエンティティ（DBに登録済みの学習記録）
	 */
	@Transactional
	public StudyLog saveWithSkills(StudyLogForm studyLogForm) {
	    // StudyLog（学習記録）エンティティを作成し、DBに保存する
	    StudyLog savedLog = studyLogRepository.save(
	        StudyLog.builder()
	            .description(studyLogForm.getDescription())        // 学習内容の詳細をセット
	            .studyTimeMinutes(studyLogForm.getStudyTimeMinutes()) // 勉強時間（分）をセット
	            .build()
	    );

	    // スキルIDリストが空でなければ、対応するSkillエンティティを一括取得し、関連付ける
	    if (studyLogForm.getSkillIds() != null && !studyLogForm.getSkillIds().isEmpty()) {
	        // 選択されたスキルIDの一覧をまとめてDBから取得
	        List<Skill> skills = skillRepository.findAllById(studyLogForm.getSkillIds());

	        // 取得したスキルごとにStudyLogSkill（学習記録とスキルの関連テーブル）を作成・保存
	        for (Skill skill : skills) {
	            studyLogSkillRepository.save(
	                StudyLogSkill.builder()
	                    .id(new StudyLogSkillId(savedLog.getId(), skill.getId())) // 複合キー（学習記録ID＋スキルID）を作成
	                    .studyLog(savedLog)                                        // 学習記録側のリレーションをセット
	                    .skill(skill)                                             // スキル側のリレーションをセット
	                    .build()
	            );
	        }
	    }

	    // 保存済みの学習記録を呼び出し元に返す
	    return savedLog;
	}
}

