package com.groupware.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import com.groupware.global.Config;
import com.groupware.vo.CommonSearchVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
		private String name;
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
