package com.groupware.mapper;

import java.io.Console;
import java.util.List;

import com.groupware.dto.BoardDTO;

public interface BoardMapper {
//	@Select("select * from tbl_board")
	public List<BoardDTO> getBoardList();
	
	public void insert(BoardDTO board);

	public void insertSelectKey(BoardDTO board);
	
	public List<BoardDTO> reads(Long employee_idx);

	public int update(BoardDTO boardDTO);

	public int delete(long boardIdx);
	
	public BoardDTO select(long boardIdx);
	
	
	public List<BoardDTO> selectemployee_idx(int employeeIdx);
}
