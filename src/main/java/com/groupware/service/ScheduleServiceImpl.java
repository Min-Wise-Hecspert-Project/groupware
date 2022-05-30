package com.groupware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.Schedule;
import com.groupware.dto.Schedule.ScheduleDTO;
import com.groupware.mapper.ScheduleMapper;
import com.groupware.vo.ScheduleVO;

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
	public boolean updateSchedule(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSchedule(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertSchedule(Schedule.ScheduleDTO dto) {
		// TODO Auto-generated method stub
		return 1 == scheduleMapper.modify(dto);
	}


}
