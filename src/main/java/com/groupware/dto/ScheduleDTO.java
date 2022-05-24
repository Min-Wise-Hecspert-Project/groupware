package com.groupware.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Alias("scheduleDTO")
public class ScheduleDTO {
	@NonNull
	private Long scheduleIdx;
	@NonNull
	private Long employeeIdx;
	@NonNull
	private Long state;
	@NonNull
	private Date insDate;
	@NonNull
	private Date updDate;
	@NonNull
	private Date startDate;
	@NonNull
	private Date endDate;
	
	private String file;
	
	private String participant;
	
	
	
}
