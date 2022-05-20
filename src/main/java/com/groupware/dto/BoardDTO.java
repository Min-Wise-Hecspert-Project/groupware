package com.groupware.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
}
