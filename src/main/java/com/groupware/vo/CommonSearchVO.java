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

	private Integer perPage;
	private Integer startNum;
	private Integer endNum;


	public CommonSearchVO(String title, String content, String writer, Integer sorting, Integer page, Integer perPage) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.sorting = sorting;
		this.page = page;
		this.startNum = (page-1)*perPage;
		this.endNum = page*perPage;
	}

	public CommonSearchVO(String writer, Integer sorting, Integer page, Integer perPage) {
		this.writer = writer;
		this.sorting = sorting;
		this.page = page;
		this.startNum = (page-1)*perPage;
		this.endNum = page*perPage;
	}



	
	//board 값넣기
	
}
