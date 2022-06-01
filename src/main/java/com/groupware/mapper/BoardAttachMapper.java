package com.groupware.mapper;

import java.util.List;

import com.groupware.vo.BoardAttachVO;


public interface BoardAttachMapper {
	public void insert(BoardAttachVO vo);
	public int delete(String uuid);
	public List<BoardAttachVO> findByboardIdx(Long boardIdx);
	public int deleteAll(Long boardIdx);
	public List<BoardAttachVO> getOldFiles();
}
