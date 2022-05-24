package com.groupware.notice;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.groupware.config.RootConfig;
import com.groupware.config.ServletConfig;
import com.groupware.dto.NoticeDTO;
import com.groupware.global.Sorting;
import com.groupware.mapper.NoticeMapper;
import com.groupware.vo.SearchVO;

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
		//new SearchVO("제목", "내용", "작성자", 정렬, 페이지);
		String title = "";
		String content = "성공";
		String writer = "";
		Integer sorting = Sorting.sortByinsDateDESC.getValue();
		Integer page = 1;
		Integer pageSize = 3;
		try {
			SearchVO searchVO = new SearchVO(title, content, writer, sorting, page, pageSize); 
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
