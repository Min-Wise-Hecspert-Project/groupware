package com.groupware.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Getter
public class SearchVO {
	private String title;
	private String content;
	private String writer;
	private Integer sorting;
	private Integer page;
}
