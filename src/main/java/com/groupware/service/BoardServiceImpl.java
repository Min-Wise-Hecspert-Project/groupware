package com.groupware.service;

import java.util.List;

import com.groupware.dto.BoardDTO;
import com.groupware.dto.Notice;
import com.groupware.mapper.BoardMapper;
import com.groupware.vo.BoardVO;
import com.groupware.vo.CommonSearchVO;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper; 
	
	@Override
	public void register(BoardDTO board) {
		log.info("register...." + board.getBoardIdx());
		mapper.insertSelectKey(board);
	}

	@Override
	public List<BoardDTO> gets(Long employee_idx) {
		log.info("get...." + employee_idx);
		return mapper.reads(employee_idx);
	}
	@Override
	public BoardDTO select(Long board_idx) {
		// TODO Auto-generated method stub
		return mapper.select(board_idx);
	}


	@Override
	public BoardDTO modify(BoardDTO board) {
		log.info("modify...." + board);
		mapper.update(board);
		return select(board.getBoardIdx());
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove...." + bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardDTO> getList() {
		log.info("getList....");
		return mapper.getBoardList();
	}

	@Override
	public List<BoardDTO> selectList(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return mapper.getBoardList();
	}



	
	
}
