package com.example.NextCoder.form;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudyLogForm {
	private String description;
	@Min(value = 1, message = "勉強時間は1分以上で入力して下さい")
	private int studyTimeMinutes;

	@NotEmpty(message = "スキルを一つ以上選択してください")
	private List<Long> skillIds;
}
