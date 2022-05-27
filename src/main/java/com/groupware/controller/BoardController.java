package com.groupware.controller;

import com.groupware.dto.BoardDTO;
import com.groupware.global.Config;
import com.groupware.service.BoardService;
import com.groupware.vo.BoardVO;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/api/board/*")
@AllArgsConstructor
@ResponseBody
public class BoardController {

		private BoardService service; 
		
//		@GetMapping("/list")
//		public void list(Model model) {
//			log.info("list");
//			model.addAttribute("list", service.getList());
//		}
		@GetMapping("/22")
		public String addr(@RequestParam("name")String name){
			return name;
			
			
		}
		@GetMapping("/list")
		public ResponseEntity<List<BoardDTO>>list(
				@RequestParam(defaultValue = "") String title,
				@RequestParam(defaultValue = "") String content,
				@RequestParam(defaultValue = "1") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page,
				@RequestParam(defaultValue = "1") String boardType
				){
			
					/*
					 * CommonSearchVO searchVO = new CommonSearchVO(title, content, sorting, page,
					 * Config.globalPageSize,boardType );
					 */
//			List<BoardDTO> dtos = service.se
			
			return null;
				
		}
		
		@GetMapping("/register")
		public void list() {
				
		}
		
		@PostMapping("/register")
		public String register(BoardDTO board, RedirectAttributes rttr) {
			log.info("register: " + board);
			service.register(board);
			rttr.addFlashAttribute("result", board.getBoardIdx());
			
			return "redirect:/board/list";
		}
		
		@GetMapping("/get")
		public void get(@RequestParam("bno") Long bno, Model model) {
			log.info("/get");
			model.addAttribute("board", service.get(bno));
		}
		
		@PostMapping("/modify")
		public String modify(BoardDTO board, RedirectAttributes rttr) {
			log.info("modify: " + board);
			if(service.modify(board)) {
				rttr.addFlashAttribute("result", board.getBoardIdx());
			}			
			
			return "redirect:/board/list";
		}
		
		@PostMapping("/remove")
		public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
			log.info("remove: " + bno);
			if(service.remove(bno)) {
				rttr.addFlashAttribute("result", "success");
			}			
			
			return "redirect:/board/list";
		}
}
