package com.groupware.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

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

import com.groupware.dto.Notice;
import com.groupware.service.NoticeService;
import com.groupware.vo.CommonSearchVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j
public class NoticeController {

		private final NoticeService service;

		@GetMapping("/notice")
		public ResponseEntity<Map<String, Object>> list(
				@RequestParam(defaultValue = "") String title,
				@RequestParam(defaultValue = "") String content,
				@RequestParam(defaultValue = "") String writer,
				@RequestParam(defaultValue = "") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page,
				@RequestParam(defaultValue = "10") Integer perPage
				) {
			
			CommonSearchVO searchVO = new CommonSearchVO(title, content, writer, sorting, page, perPage);

			return service.selectList(searchVO);
		}
		
		@PostMapping("/notice")
		public ResponseEntity<Notice.DetailDTO> post(Notice.InsertDTO insertDTO, HttpSession session) {
			insertDTO.setEmployeeIdx((Long) session.getAttribute("employeeIdx"));
			return service.insert(insertDTO);
		}
	
		@GetMapping("/notice/{noticeIdx}")
		public ResponseEntity<Notice.DetailDTO> get(@PathVariable("noticeIdx") Long noticeIdx) {
			return service.select(noticeIdx);
		}
		
		@PutMapping("/notice")
		public ResponseEntity<Notice.DetailDTO> put(@RequestBody Notice.UpdateDTO updateDTO) {
			return service.update(updateDTO);
		}
		
		@DeleteMapping("/notice/{noticeIdx}")		
		public ResponseEntity<Notice.DetailDTO> delete(@PathVariable("noticeIdx") Long noticeIdx) {
			return service.delete(noticeIdx);
		}
		
		@DeleteMapping("/notice/cron")
		public ResponseEntity<Map<String, Object>> deleteBySchedule() {
			return service.deleteBySchedule();
		}
}