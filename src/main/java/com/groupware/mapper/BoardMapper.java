package com.groupware.mapper;

import java.util.List;

import com.groupware.vo.BoardVO;

public interface BoardMapper {
//	@Select("select * from tbl_board")
	public List<BoardVO> getBoardList();
	
	public void insert(BoardVO board);

	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);

	public int update(BoardVO boardVO);

	public int delete(long l);
}
