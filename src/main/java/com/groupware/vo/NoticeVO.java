package com.groupware.vo;

import lombok.Data;

@Data
public class NoticeVO {
	private long noticeIdx;
	private long employeeIdx;
	private String title;
	private String contents;
	private String files;
	private String insDate;
	private String updDate;
	private long state;

}
