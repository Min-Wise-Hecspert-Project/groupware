package com.groupware.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Schedule {
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class ScheduleDTO {

		private Long scheduleIdx;
		private Long employeeIdx;
		private Long state;
		private String title;
		private String content;
		private String calendarId;
		private String location;
		private String place;
		private Date insDate;
		private Date updDate;
		private Date startDate;
		private Date endDate;		
		private String file;		
		private String participant;
		
	}
}
