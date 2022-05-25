package com.groupware.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NonNull;

@Data
@Alias("ScheduleVO")
public class ScheduleVO {
	@NonNull
	private String name;
	private String title;
	private String content;
	private String file;
	private String participant;
	private String place;
	private String location;
	private Long scheduleIdx;
	private Long employee;
	private Long state;
	private Date insDate;
	private Date updDate;
	private Date startDate;
	private Date endDate;
}
