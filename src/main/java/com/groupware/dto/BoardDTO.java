package com.groupware.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.groupware.vo.BoardAttachVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Alias("BoardDTO")
public class BoardDTO {
	
	
	
	public BoardDTO(Long employeeIdx, String boardType, String content, String title) {
		super();
		this.employeeIdx = employeeIdx;
		this.boardType = boardType;
		this.content = content;
		this.title = title;
	}


	@NonNull
	private Long boardIdx;
	private Long employeeIdx;
	private String boardType="";
	private String content;

	private String File="";
	
	private String insDate;
	
	private String updDate;
	
	private String state;
	
	private String title;
	private List<BoardAttachVO> attachList;

	
	
}
