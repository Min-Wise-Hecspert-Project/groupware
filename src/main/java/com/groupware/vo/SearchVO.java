package com.groupware.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString

public class SearchVO {
	private String title;
	private String content;
	private String writer;
	private Integer sorting;
	private Integer page;
	private Integer pageSize;
	private Integer startNum;
	
	public SearchVO(String title, String content, String writer, Integer sorting, Integer page, Integer pageSize) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.sorting = sorting;
		this.page = page;
		this.pageSize = pageSize;
		this.startNum = (page-1)*pageSize;
	}

	
}
