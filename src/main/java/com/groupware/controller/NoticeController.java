package com.groupware.controller;

import com.groupware.dto.Notice;
import com.groupware.service.NoticeService;
import com.groupware.vo.CommonSearchVO;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j
public class NoticeController {

		private final NoticeService service;
		
		@GetMapping("/notice")
		public ResponseEntity<List<Notice.listDTO>> list(
				@RequestParam(defaultValue = "") String title,
				@RequestParam(defaultValue = "") String content,
				@RequestParam(defaultValue = "") String writer,
				@RequestParam(defaultValue = "") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page
				) {
			
			CommonSearchVO searchVO = new CommonSearchVO(title, content, writer, sorting, page);
			
			return service.selectList(searchVO);
		}
		
		@PostMapping("/notice")
		public ResponseEntity<Notice.detailDTO> post(Notice.insertDTO insertDTO) {
			return service.insert(insertDTO);
		}
		
		@GetMapping("/notice/{noticeIdx}")
		public ResponseEntity<Notice.detailDTO> get(@PathVariable("noticeIdx") Long noticeIdx) {
			return service.select(noticeIdx);
		}
		
		@PutMapping("/notice")
		public ResponseEntity<Notice.detailDTO> put(@RequestBody Notice.updateDTO updateDTO) {
			return service.update(updateDTO);
		}
		
		@DeleteMapping("/notice/{noticeIdx}")		
		public ResponseEntity<Notice.detailDTO> delete(@PathVariable("noticeIdx") Long noticeIdx) {
			return service.delete(noticeIdx);
		}
		
		@DeleteMapping("/notice/schedule")
		public void deleteBySchedule(RedirectAttributes rttr) {
			log.info("deleteBySchedule: ");	
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(null); // 수정 필요
		}
}
