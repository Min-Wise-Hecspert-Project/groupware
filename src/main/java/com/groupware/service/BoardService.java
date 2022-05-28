package com.groupware.service;

import java.util.List;

import com.groupware.dto.BoardDTO;
import com.groupware.dto.Notice;
import com.groupware.vo.CommonSearchVO;

public interface BoardService {
	public void register(BoardDTO board);
	public List<BoardDTO> selectList(BoardDTO boardDTO);

	public List<BoardDTO> gets(Long employee_idx);
	public boolean modify(BoardDTO board);
	public boolean remove(Long board_idx);
	public List<BoardDTO> getList(); 
	
}
