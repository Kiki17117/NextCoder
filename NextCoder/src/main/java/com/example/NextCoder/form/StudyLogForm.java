package com.example.NextCoder.form;

import java.util.List;

import lombok.Data;

@Data
public class StudyLogForm {
	private String description;
	private int studyTimeMinutes;

	private List<Long> skillIds;
}
