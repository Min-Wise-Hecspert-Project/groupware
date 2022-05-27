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
	
<<<<<<< HEAD
	//board 추가
	private String boardType;
	
	public CommonSearchVO(String title, String content, String writer, Integer sorting, Integer page, Integer pageSize) {
=======
	public CommonSearchVO(String title, String content, String writer, Integer sorting, Integer page) {
>>>>>>> 8ad11253451bd0e9a7a9c375aa30f1c1c0c6299d
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
<<<<<<< HEAD



	public CommonSearchVO(String title, String content, Integer sorting, Integer page, Integer pageSize,
			String boardType) {
		super();
		this.title = title;
		this.content = content;
		this.sorting = sorting;
		this.page = page;
		this.pageSize = pageSize;
		this.boardType = boardType;
	}
	
	//board 값넣기
	

	
=======
>>>>>>> 8ad11253451bd0e9a7a9c375aa30f1c1c0c6299d
}
