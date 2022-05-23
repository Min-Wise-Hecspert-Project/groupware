package com.groupware.service;

import java.util.List;

import com.groupware.dto.BoardDTO;

public interface BoardService {
	public void register(BoardDTO board);
	public BoardDTO get(Long board_idx);
	public boolean modify(BoardDTO board);
	public boolean remove(Long board_idx);
	public List<BoardDTO> getList(); 
	
}
