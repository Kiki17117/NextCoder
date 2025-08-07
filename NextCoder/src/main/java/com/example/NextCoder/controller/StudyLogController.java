package com.example.NextCoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.NextCoder.entity.StudyLog;
import com.example.NextCoder.form.StudyLogForm;
import com.example.NextCoder.service.SkillService;
import com.example.NextCoder.service.StudyLogService;
import com.example.NextCoder.service.StudyLogSkillService;

@Controller
public class StudyLogController {

	@Autowired
	private StudyLogService studyLogService;
	@Autowired
	private StudyLogSkillService studyLogSkillService;
	@Autowired
	private SkillService skillService;

	@GetMapping("/studyLog/add")
	public String showLogForm(Model model) {
		model.addAttribute("studyLogForm", new StudyLogForm());
		model.addAttribute("skills", skillService.getAllSkills());
		return "studyLog/add";
	}


	@PostMapping("/studyLog/add")
	public String submitLog(@ModelAttribute("logForm") StudyLogForm studyLogForm) {
		StudyLog savedStudyLog = studyLogService.save(studyLogForm);

		List<Long> skillIds = studyLogForm.getSkillIds();
		if(skillIds != null && !skillIds.isEmpty()) {
			studyLogSkillService.addSkillsToStudyLog(savedStudyLog.getId(), skillIds);
		}
		return "redirect:/studyLog/dashboard";
	}

}
