package com.groupware.dto;

import java.sql.Date;

import com.groupware.global.Config;
import com.groupware.vo.CommonSearchVO;
import lombok.*;

public class Notice {

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter	@Setter	@ToString
	public static class PageVO {
		private int totalDataCnt;
		private int currentDataCnt;
		private int totalPage;
		private int currentPage;
		private boolean isLastPage;
		private boolean isFirstPage;
		private int requestPage;

		PageVO(CommonSearchVO searchVO, int totalDataCnt){
			this.totalDataCnt = totalDataCnt; // DB
			this.currentDataCnt = totalDataCnt % Config.PAGE_SIZE;
			this.totalPage = (int) Math.ceil(totalDataCnt / Config.PAGE_SIZE);
			this.requestPage = searchVO.getPage();
			this.isLastPage =  this.totalPage == searchVO.getPage();
			this.isFirstPage = searchVO.getPage() == 1;
		}
	}

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
