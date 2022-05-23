package com.groupware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.groupware.service.ScheduleServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {
	private ScheduleServiceImpl serviceImpl;
	
	@GetMapping("/")
	public String list(Model model) {
		log.info("/schedule/list");
		model.addAttribute("list", serviceImpl.getSchedule());
		
		return "/schedule/list";
	}
}
