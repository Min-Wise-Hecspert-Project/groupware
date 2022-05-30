package com.groupware.dto;

import java.sql.Date;

import lombok.*;
import org.apache.ibatis.type.Alias;

public class Notice {

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class DetailDTO {
		private Long noticeIdx;
		private Long employeeIdx;
		private String title;
		private String content;
		private String file;
		private Date insDate;
		private Date updDate;
		private Integer state;
		private String name;
		private String enName;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class ListDTO {
		private Long noticeIdx;
		private Long employeeIdx;
		private String title;
		private Date insDate;
		private Date updDate;
		private Integer state;
		private String name;
		private String enName;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class InsertDTO {
		private Long noticeIdx;
		private Long employeeIdx;
		private String title;
		private String content;
		private String file;
		private Integer state;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class DeleteDTO {
		private Long noticeIdx;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class UpdateDTO {
		private Long noticeIdx;
		private String title;
		private String content;
		private String file;
		private Integer state;
	}
}
