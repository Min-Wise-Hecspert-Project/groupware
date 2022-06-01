package com.groupware.controller;

import java.util.List;


import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		Schedule.ScheduleDTO getDto = service.insertSchedule(dto);
		if (getDto!=null) {
			return new ResponseEntity<>(getDto,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/schedule/{scheduleIdx}")
	public ResponseEntity<String> delete(@PathVariable(value = "scheduleIdx") Long scheduleIdx){
		service.deleteSchedule(scheduleIdx);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	@PutMapping("/schedule")
	public ResponseEntity<Schedule.ScheduleDTO> update(@RequestBody Schedule.ScheduleDTO dto){
		System.out.println(dto);
		Schedule.ScheduleDTO getDto = service.updateSchedule(dto);
		return new ResponseEntity<>(getDto,HttpStatus.OK);
	}
	 
}
