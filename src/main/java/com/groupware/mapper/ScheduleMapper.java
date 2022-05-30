package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.Schedule;

public interface ScheduleMapper {
	public List<Schedule.ScheduleDTO> selectList();
	public int modify(Schedule.ScheduleDTO dto);
}
