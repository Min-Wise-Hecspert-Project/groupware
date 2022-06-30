package com.groupware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.Schedule;
import com.groupware.dto.Schedule.ScheduleDTO;
import com.groupware.mapper.ScheduleMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleMapper scheduleMapper;
	@Override
	public List<ScheduleDTO> getSchedule() {
		
		return scheduleMapper.selectList();
	}

	@Override
	public Schedule.ScheduleDTO updateSchedule(Schedule.ScheduleDTO dto) {
		if (1==scheduleMapper.modify(dto)) {
			return scheduleMapper.getSchedule(dto.getScheduleIdx());
		}
		return null;
	}

	@Override
	public boolean deleteSchedule(Long scheduleIdx) {
		
		return 1==scheduleMapper.removeSchedule(scheduleIdx);
	}

	@Override
	public Schedule.ScheduleDTO insertSchedule(Schedule.ScheduleDTO dto) {
		// TODO Auto-generated method stub
		if (1==scheduleMapper.register(dto)) {
			return scheduleMapper.getSchedule(dto.getScheduleIdx());		
		}
		return null;
	}


}
