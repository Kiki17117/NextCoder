package com.example.NextCoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.NextCoder.form.StudyLogForm;
import com.example.NextCoder.service.SkillService;
import com.example.NextCoder.service.StudyLogService;

import jakarta.validation.Valid;

@Controller
public class StudyLogController {

	@Autowired
	private StudyLogService studyLogService;
	@Autowired
	private SkillService skillService;

	@GetMapping("/studyLog/dashboard")
		public String dashboard() {
			return "studyLog/dashboard";
		}

	@GetMapping("/studyLog/add")
	public String showLogForm(Model model) {
		model.addAttribute("studyLogForm", new StudyLogForm());
		model.addAttribute("skills", skillService.getAllSkills());
		return "studyLog/add";
	}


	@PostMapping("/studyLog/add")
	public String submitLog(@Valid @ModelAttribute("studyLogForm") StudyLogForm studyLogForm,
							BindingResult bindingResult,
							Model model) {

		if(bindingResult.hasErrors()) {
			// エラーがあれば再度スキル一覧をセットしフォームを表示
	        model.addAttribute("skills", skillService.getAllSkills());
	        return "studyLog/add";
		}

		// バリデーションOkなら保存処理へ
		studyLogService.saveWithSkills(studyLogForm);

	    return "redirect:/studyLog/dashboard";
	}

}
