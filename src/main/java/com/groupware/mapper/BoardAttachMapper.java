package com.groupware.mapper;

import java.util.List;

import com.groupware.vo.BoardAttachVO;


public interface BoardAttachMapper {
	public void insert(BoardAttachVO vo);
	public int delete(String uuid);
	public List<BoardAttachVO> findByBno(Long bno);
	public int deleteAll(Long bno);
	public List<BoardAttachVO> getOldFiles();
}
