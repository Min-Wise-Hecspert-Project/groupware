package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.BoardDTO;

public interface BoardMapper {
//	@Select("select * from tbl_board")
	public List<BoardDTO> getBoardList();
	
	public void insert(BoardDTO board);

	public void insertSelectKey(BoardDTO board);
	
	public BoardDTO read(Long bno);

	public int update(BoardDTO boardVO);

	public int delete(long l);
}
