package com.groupware.vo;


import lombok.Data;

@Data
public class BoardVO {
	private long board_idx;
	private String employee_idx;
	private String board_type;
	private String content;
	private String attached_file;
	private String date_Created;
	private String modified_Date;
	private String state;


}
