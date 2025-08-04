package com.example.NextCoder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.NextCoder.form.RecordForm;

@Controller
public class RecordController {

	@GetMapping("/record")
	public String showRecordPage(Model model) {
		model.addAttribute("recordForm",new RecordForm());
		return "record";
	}
}
