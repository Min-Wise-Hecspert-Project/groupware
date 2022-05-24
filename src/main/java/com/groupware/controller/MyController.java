package com.groupware.controller;

import java.util.List;

import com.groupware.mapper.BoardMapper;
import com.groupware.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board")
public class MyController {

	@Autowired
	private BoardMapper boardMapper;
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	@ResponseBody
	public List<BoardVO> boardList(Model model) {
		log.info("boardList...");
		List<BoardVO> boardList = boardMapper.getBoardList();
		
//		model.addAttribute("boardList", boardList);
		 
		return List<BoardVO>;
	}
}
