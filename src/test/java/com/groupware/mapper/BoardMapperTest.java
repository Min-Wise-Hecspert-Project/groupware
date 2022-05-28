package com.groupware.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.groupware.config.RootConfig;
import com.groupware.dto.BoardDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BoardMapperTest {
	@Setter(onMethod_ = @__({@Autowired}))
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getBoardList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardDTO board = new BoardDTO();
		board.setEmployeeIdx(1L);
		board.setBoardType("1");
		board.setContent("newbie");
		board.setFile("file");
		board.setState("!!");
		board.setTitle("ww");
		mapper.insert(board);
		log.info(board);
	}
	
	@Test
	public void testJoin() {
		mapper.selectemployee_idx(1);
		log.info(mapper);
		
	}


	

//	
//	@Test
//	public void testInsertKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새글 selectKey");
//		board.setContent("새글 selectKey");
//		board.setWriter("newbie");
//		mapper.insertSelectKey(board);
//		log.info(board);
//	}
	
	
	
//	@Test
//	public void testRead() {
//		BoardDTO board = mapper.read(9L);
//		log.info(board);
//	}
//	@Test
//	public void testDelete() {
//		log.info("DELETE COUNT : " + mapper.delete(5L));
//	}
//	
//	@Test
//	public void testUpdate() {
//		BoardDTO board = new BoardDTO();
//		board.setBoardIdx(9L);
//		board.setTitle("수정한 제목");
//		board.setContent("수정한 내용");
//		board.setFile("rose");
//		
//		int count = mapper.update(board);
//		log.info("UPDATE COUNT : " +count);
//	}
//	@Test
//	public void testSearch() {
//		Criteria cri = new Criteria();
//		cri.setKeyword("asdf");
//		cri.setType("TC");
//		List<BoardVO> list = mapper.getListWithSearch(cri);
//		list.forEach(board -> log.info(board));
//	}	
}










