package com.groupware.service;

import java.util.List;

import com.groupware.vo.ScheduleVO;

public interface ScheduleService {
	public List<ScheduleVO> getSchedule();
	public boolean updateSchedule(ScheduleVO vo);
	public boolean deleteSchedule(ScheduleVO vo);
}
