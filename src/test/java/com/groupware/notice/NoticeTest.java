package com.groupware.notice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.groupware.config.RootConfig;
import com.groupware.config.ServletConfig;
import com.groupware.controller.NoticeController;
import com.groupware.dto.NoticeDTO;
import com.groupware.global.Config;
import com.groupware.global.Sorting;
import com.groupware.mapper.NoticeMapper;
import com.groupware.service.NoticeService;
import com.groupware.vo.CommonSearchVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@Log4j
public class NoticeTest {

	@Autowired
	NoticeMapper mapper;
	
	@Autowired
	NoticeService ns;
	
	@Test
	public void testGetNoticeList() {
		String title = "";
		String content = "성공";
		String writer = "";
		Integer sorting = Sorting.ORDER_BY_INS_DATE_DESC.getValue();
		Integer page = 1;
		int pageSize = Config.globalPageSize;
		
		try {
			CommonSearchVO searchVO = new CommonSearchVO(title, content, writer, sorting, page, pageSize); 
			log.info(mapper.selectList(searchVO));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		
		log.info(ns.insert(noticeDTO));
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
