package com.groupware.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Alias("NoticeDTO")
public class NoticeDTO {
	
	@NonNull
	private Long noticeIdx;
	
	@NonNull
	private Long employeeIdx;
	
	@NonNull
	private String title;
	
	@NonNull
	private String content;
	
	private String file;
	
	@NonNull
	private Date insDate;
	
	@NonNull
	private Date updDate;
	
	@NonNull
	private Integer state;
	
	@NonNull
	private EmployeeDTO employeeDTO;
	
	
}
