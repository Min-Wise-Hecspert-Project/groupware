package com.groupware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupware.dto.Notice;
import com.groupware.dto.Schedule;
import com.groupware.service.ScheduleService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/api")
@AllArgsConstructor
public class ScheduleController {
	
	@Autowired
	ScheduleService service;
	
	@GetMapping("/schedule")
	public ResponseEntity<List<Schedule.ScheduleDTO>> scheduleList() {
		return new ResponseEntity<>(service.getSchedule() ,HttpStatus.OK);
	}
	@PostMapping("/schedule")
	public ResponseEntity<Schedule.ScheduleDTO> post(Schedule.ScheduleDTO dto) {
		if (service.insert(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
