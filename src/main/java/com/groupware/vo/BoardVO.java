package com.groupware.vo;


import lombok.Data;

@Data
public class BoardVO {
	private long boardIdx;
	private long employeeIdx;
	private String boardType;
	private String content;
	private String attachedFile;
	private String dateCreated;
	private String modifiedDate;
	private long state;


}
