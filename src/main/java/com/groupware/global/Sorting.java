package com.groupware.global;

public enum Sorting {
	sortByTitleASC(1),
	sortByTitleDESC(2),
	sortByWriterASC(3),
	sortByWriterDESC(4),
	sortByinsDateASC(5),
	sortByinsDateDESC(6),
	sortByViewCntASC(7),
	sortByViewCntDESC(8);
	
	private Integer value;

	Sorting(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
