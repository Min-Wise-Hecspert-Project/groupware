package com.groupware.dto;

import java.sql.Date;

import lombok.*;
import org.apache.ibatis.type.Alias;

public class Notice {

	@Alias("NoticeDetailDTO")
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class detailDTO{
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

	@Alias("NoticeListDTO")
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class listDTO{
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
	public static class insertDTO{
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
	public static class deleteDTO{
		private Long noticeIdx;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class updateDTO{
		private Long noticeIdx;
		private String title;
		private String content;
		private String file;
		private Integer state;
	}
}
