package com.groupware.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeListVO {
	private Long noticeIdx;
	private Long employeeIdx;
	private String title;
	private String content;
	private String file;
	private Date insDate;
	private Date updDate;
	private Integer state;
}
