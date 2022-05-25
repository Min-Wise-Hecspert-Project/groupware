package com.groupware.vo;

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
	private Integer pageSize;
	private Integer startNum;
	
	public CommonSearchVO(String title, String content, String writer, Integer sorting, Integer page, Integer pageSize) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.sorting = sorting;
		this.page = page;
		this.pageSize = pageSize;
		this.startNum = (page-1)*pageSize;
	}

	public CommonSearchVO( String writer, Integer sorting, Integer page, Integer pageSize) {
		this.writer = writer;
		this.sorting = sorting;
		this.page = page;
		this.pageSize = pageSize;
		this.startNum = (page-1)*pageSize;
	}

	
}
