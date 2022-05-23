package com.groupware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.ScheduleDTO;
import com.groupware.vo.ScheduleVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleDTO dto;
	@Override
	public List<ScheduleVO> getSchedule() {
		// TODO Auto-generated method stub
		return dto.getSchedule();
	}

	@Override
	public boolean updateSchedule(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return 1==dto.updateSchedule(vo);
	}

	@Override
	public boolean deleteSchedule(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return 1==dto.deleteSchedule(vo);
	}

}
