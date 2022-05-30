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
		attachVO.setUuid("1");
		attachVO.setBoardIdx(1L);
		attachVO.setUploadpath("sdf");
		attachVO.setFileType(true);
		attachVO.setFileName("sdf");
	
		boardAttachMapper.insert(attachVO);
	}
}
