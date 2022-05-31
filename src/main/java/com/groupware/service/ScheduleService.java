package com.groupware.service;

import java.util.List;

import com.groupware.dto.Schedule;
import com.groupware.vo.ScheduleVO;

public interface ScheduleService {
	public List<Schedule.ScheduleDTO> getSchedule();
	public Schedule.ScheduleDTO insertSchedule(Schedule.ScheduleDTO dto);
	public Schedule.ScheduleDTO updateSchedule(Schedule.ScheduleDTO dto);
	public boolean deleteSchedule(Long scheduleIdx);
}
