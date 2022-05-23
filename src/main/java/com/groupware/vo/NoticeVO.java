package com.groupware.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NonNull;

@Data
@Alias("noticeVO")
public class NoticeVO {
	
	@NonNull
	private Long noticeIdx;
	private Long employeeIdx;
	private String title;
	private String content;
	private String file;
	private Date insDate;
	private Date updDate;
	private Integer state;
}
