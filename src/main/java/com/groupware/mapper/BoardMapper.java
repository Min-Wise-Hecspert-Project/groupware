package com.groupware.mapper;

import java.io.Console;
import java.util.List;
import java.util.Map;

import com.groupware.dto.BoardDTO;

public interface BoardMapper {
//	@Select("select * from tbl_board")
	public List<BoardDTO> getBoardList();
	
	public void insert(BoardDTO board);

	public void insertSelectKey(BoardDTO boardIdx);
	
	public List<BoardDTO> reads(Long employee_idx);

	public int update(BoardDTO boardDTO);

	public int delete(long boardIdx);
	
	public BoardDTO select(long boardIdx);
	
	
	public List<BoardDTO> selectemployee_idx(int employeeIdx);
	
	
	//file
	public void insertFile(Map<String, Object> map) throws Exception;

}
