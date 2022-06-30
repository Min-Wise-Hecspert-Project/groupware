package com.groupware.global;

public enum Sorting {
	ORDER_BY_TITLE_ASC(1,"제목 오름차순"),
	ORDER_BY_TITLE_DESC(2,"제목 내림차순"),
	ORDER_BY_WRITER_ASC(3,"작성자명 오름차순"),
	ORDER_BY_WRITER_DESC(4,"작성자명 내림차순"),
	ORDER_BY_INS_DATE_ASC(5,"등록일 오름차순"),
	ORDER_BY_INS_DATE_DESC(6,"등록일 내림차순"),
	ORDER_BY_VIEW_CNT_ASC(7,"조회수 오름차순"),
	ORDER_BY_VIEW_CNT_DESC(8,"조회수 내림차순");
	
	private final Integer value;
	private final String description;

	private Sorting(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
}
