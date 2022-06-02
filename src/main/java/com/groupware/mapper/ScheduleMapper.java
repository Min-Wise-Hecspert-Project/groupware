package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.Schedule;

public interface ScheduleMapper {
	public List<Schedule.ScheduleDTO> selectList();
	public int register(Schedule.ScheduleDTO dto);
	public int modify(Schedule.ScheduleDTO dto);
	public Schedule.ScheduleDTO getSchedule(Long scheduleIdx);
	public int removeSchedule(Long scheduleIdx);
}
