package com.groupware.vo;

import com.groupware.global.Config;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class CommonSearchVO {
	private String title;
	private String content;
	private String writer;
	private Integer sorting;
	private Integer page;
	private Integer startNum;
	private Integer endNum;

	private final int pageSize = Config.globalPageSize;
	
	//board 추가
	private String boardType;
	
	public CommonSearchVO(String title, String content, String writer, Integer sorting, Integer page) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.sorting = sorting;
		this.page = page;
		this.startNum = (page-1)*this.pageSize;
		this.endNum = page*this.pageSize;
	}

	public CommonSearchVO(String writer, Integer sorting, Integer page) {
		this.writer = writer;
		this.sorting = sorting;
		this.page = page;
		this.startNum = (page-1)*this.pageSize;
		this.endNum = page*this.pageSize;
	}



	
	//board 값넣기
	
}
