package com.groupware.notice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.groupware.config.RootConfig;
import com.groupware.config.ServletConfig;
import com.groupware.dto.NoticeDTO;
import com.groupware.mapper.NoticeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@Log4j
public class NoticeTest {

	@Autowired
	NoticeMapper mapper;
	
	@Test
	public void testGetNoticeList() {
		log.info(mapper.selectList());
	}
	
	@Test
	public void testGetNotice() {
		log.info(mapper.select(1L));
	}
	
	@Test
	public void testInsert() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setEmployeeIdx(1L);
		noticeDTO.setTitle("삽입 테스트~~");
		noticeDTO.setContent("성공");
		noticeDTO.setFile("");
		mapper.insert(noticeDTO);
	}
	
	@Test
	public void testUpdate() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeIdx(8L);
		noticeDTO.setTitle("수정!!!!!");
		noticeDTO.setContent("성공");
		noticeDTO.setFile("");
		mapper.update(noticeDTO);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(8L);
	}
	
}
