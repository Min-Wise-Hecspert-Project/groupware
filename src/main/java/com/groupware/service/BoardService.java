package com.groupware.service;

import java.util.List;

import com.groupware.dto.BoardDTO;
import com.groupware.dto.NoticeDTO;
import com.groupware.vo.CommonSearchVO;

public interface BoardService {
	public void register(BoardDTO board);
	public List<NoticeDTO> selectList(CommonSearchVO searchVO);

	public BoardDTO get(Long board_idx);
	public boolean modify(BoardDTO board);
	public boolean remove(Long board_idx);
	public List<BoardDTO> getList(); 
	
}
