package com.groupware.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "BoardAttachVO")
public class BoardAttachVO {
	private String uuid;
	private String uploadpath;
	private String fileName;
	private boolean fileType;
	private Long boardIdx;	
}
