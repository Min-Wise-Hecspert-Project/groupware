package com.groupware.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.groupware.config.RootConfig;
import com.groupware.vo.BoardAttachVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class AttachBoardMapper {
	@Autowired
	private BoardAttachMapper boardAttachMapper;

	@Test
	public void testinsert() {
		BoardAttachVO attachVO = new BoardAttachVO();
		attachVO.setUuid("15");
		attachVO.setBoardIdx(9L);
		attachVO.setUploadpath("sdf");
		attachVO.setFileType(true);
		attachVO.setFileName("sdf");
	
		boardAttachMapper.insert(attachVO);
	}
	@Test
	public void testdelete() {
		boardAttachMapper.delete("1");
		log.info(boardAttachMapper);
	}
	@Test
	public void testAlldelete() {
		boardAttachMapper.deleteAll(1L);
		log.info(boardAttachMapper);
	}
	@Test
	public void testgetOldFiles() {
		boardAttachMapper.getOldFiles();
	}
}
