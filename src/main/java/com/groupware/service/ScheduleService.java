package com.groupware.service;

import java.util.List;

import com.groupware.dto.Schedule;
import com.groupware.vo.ScheduleVO;

public interface ScheduleService {
	public List<Schedule.ScheduleDTO> getSchedule();
	public boolean insertSchedule(Schedule.ScheduleDTO vo);
	public boolean updateSchedule(ScheduleVO vo);
	public boolean deleteSchedule(ScheduleVO vo);
}
