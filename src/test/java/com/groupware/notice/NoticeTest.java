package com.groupware.notice;

import com.groupware.dto.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.groupware.config.RootConfig;
import com.groupware.config.ServletConfig;
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
		
		try {
			CommonSearchVO searchVO = new CommonSearchVO(title, content, writer, sorting, page);
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
		Notice.InsertDTO insertDTO = new Notice.InsertDTO();
		insertDTO.setEmployeeIdx(1L);
		insertDTO.setTitle("삽입 테스트~~");
		insertDTO.setContent("성공");
		insertDTO.setFile("");
		
		log.info(ns.insert(insertDTO));
	}
	
	@Test
	public void testUpdate() {
		Notice.UpdateDTO updateDTO = new Notice.UpdateDTO();
		updateDTO.setNoticeIdx(8L);
		updateDTO.setTitle("수정!!!!!");
		updateDTO.setContent("성공");
		updateDTO.setFile("");
		mapper.update(updateDTO);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(8L);
	}
	
}
