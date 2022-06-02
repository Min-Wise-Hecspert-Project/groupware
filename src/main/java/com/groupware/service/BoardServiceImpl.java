package com.groupware.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.groupware.dto.BoardDTO;
import com.groupware.dto.Notice;
import com.groupware.mapper.BoardAttachMapper;
import com.groupware.mapper.BoardMapper;
import com.groupware.vo.BoardAttachVO;
import com.groupware.vo.BoardVO;
import com.groupware.vo.CommonSearchVO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper; 
	private BoardAttachMapper attachMapper;


	@Override
	public void register(BoardDTO board) {
		log.info("register...." + board.getBoardIdx());
		log.info("register....111" + board);
		mapper.insertSelectKey(board);
		
		if(board.getAttachList() == null || board.getAttachList().size()<=0) {
			return;
		}
		board.getAttachList().forEach(attach->{
			log.info("active ~ file upload");
			attach.setBoardIdx(board.getBoardIdx());
			attachMapper.insert(attach);
		});
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
	public boolean modify(BoardDTO board) {
		log.info("modify...." + board);
		
		
		if(board.getAttachList() == null || board.getAttachList().size()<=0) {
			return 1==mapper.update(board);
		}
		board.getAttachList().forEach(attach->{
			log.info("active ~ file upload");
			attach.setBoardIdx(board.getBoardIdx());
			attachMapper.insert(attach);
		});
		return 1==mapper.update(board);
	}
	@Override
	public int removeFile(String uuid) {
		// TODO Auto-generated method stub
		return attachMapper.delete(uuid);
	}

	@Override
	public boolean remove(Long boardIdx) {
		log.info("remove...." + boardIdx);
		attachMapper.deleteAll(boardIdx);
		return mapper.delete(boardIdx) == 1;
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

	@Override
	public List<BoardAttachVO> getAttachList(Long boardIdx) {
		// TODO Auto-generated method stub
		return attachMapper.findByboardIdx(boardIdx);
	}









	
	
}
