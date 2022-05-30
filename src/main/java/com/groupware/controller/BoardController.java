package com.groupware.controller;

import com.groupware.dto.BoardDTO;
import com.groupware.dto.Notice;
import com.groupware.global.Config;
import com.groupware.service.BoardService;
import com.groupware.vo.BoardVO;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
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
		

		//board 통쨰로 가져옴
		@GetMapping("/list")
		public ResponseEntity<List<BoardDTO>>list(){
			
			BoardDTO boardDTO = new BoardDTO();
			List<BoardDTO> dtos =service.selectList(boardDTO);
			
			if (dtos.size()<1) {
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			}else {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(dtos);
			}
			
				
		}
		
		//아이디로 조회함
		@GetMapping("/list/{employeeIdx}")
		public ResponseEntity<List<BoardDTO>> getboard_employeeIdx(
				@RequestParam(defaultValue = "") Long employeeIdx){
			
			List<BoardDTO> boardDTO = service.gets(employeeIdx);
			
			if (boardDTO==null) {
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			}else {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(boardDTO);
			}
		}
		
		@PostMapping("/register")
		public String board_register(BoardDTO board, RedirectAttributes rttr) {
			log.info("register: " + board);
			service.register(board);
			rttr.addFlashAttribute("result", board.getBoardIdx());
			
			return "redirect:/board/list";
		}
		
//		@GetMapping("/get")
//		public void get(@RequestParam("bno") Long bno, Model model) {
//			log.info("/get");
//			model.addAttribute("board", service.get(bno));
//		}
		
		@PutMapping("/modify")
		public ResponseEntity<BoardDTO>  modify(@RequestBody BoardDTO board) {
			log.info("modify: " + board);
			BoardDTO boardDTO = service.modify(board);
			
			if(board == null) {
				// �떎�뙣�떆 409 - �빐�떦 �슂泥��쓽 泥섎━媛� 鍮꾩��땲�뒪 濡쒖쭅�긽 遺덇��뒫�븯嫄곕굹 紐⑥닚�씠 �깮湲� 寃쎌슦
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);
			} else {
				// �꽦怨듭떆 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(board);
			}
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
