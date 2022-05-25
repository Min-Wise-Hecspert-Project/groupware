package com.groupware.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

	private Long boardIdx;
	private String employeeIdx;
	private String boardType;
	private String content;
	private String File;
	private String insDate;
	private String updDate;
	private String state;
	private String title;

	
	
}
