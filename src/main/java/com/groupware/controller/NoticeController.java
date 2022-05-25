package com.groupware.controller;

import com.groupware.dto.NoticeDTO;
import com.groupware.global.Config;
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
		public ResponseEntity<List<NoticeDTO>> list(
				@RequestParam(defaultValue = "") String title,
				@RequestParam(defaultValue = "") String content,
				@RequestParam(defaultValue = "") String writer,
				@RequestParam(defaultValue = "") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page
				) {
			
			CommonSearchVO searchVO = new CommonSearchVO(title, content, writer, sorting, page, Config.globalPageSize);
			
			List<NoticeDTO> dtos = service.selectList(searchVO);
			
			if(dtos.size() < 1 ) {
				// 값이 없을때 204 - 응답 body가 필요 없는 자원
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			} else {
				// 성공시 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(dtos);
			}
		}

		
		@PostMapping("/notice")
		public ResponseEntity<NoticeDTO> post(NoticeDTO noticeDTO) {

			NoticeDTO resNoticeDTO = service.insert(noticeDTO);
			
			if(resNoticeDTO == null) {
				// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);
			} else {
				// 성공시 201 - 요청에 성공하고 새로운 리소스를 만든 경우
				return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(resNoticeDTO);
			}
		}
		
		@GetMapping("/notice/{noticeIdx}")
		public ResponseEntity<NoticeDTO> get(@PathVariable("noticeIdx") Long noticeIdx) {

			NoticeDTO resNoticeDTO = service.select(noticeIdx);
			
			if(resNoticeDTO == null) {
				// 값이 없을때 204 - 응답 body가 필요 없는 자원
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(null);
			} else {
				// 성공시 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resNoticeDTO);
			}
		}
		
		@PutMapping("/notice")
		public ResponseEntity<NoticeDTO> put(@RequestBody NoticeDTO noticeDTO) {

			NoticeDTO resNoticeDTO = service.update(noticeDTO);

			if(resNoticeDTO == null) {
				// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);
			} else {
				// 성공시 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resNoticeDTO);
			}
		}
		
		@DeleteMapping("/notice/{noticeIdx}")		
		public ResponseEntity<NoticeDTO> delete(@PathVariable("noticeIdx") Long noticeIdx) {
			
			NoticeDTO resNoticeDTO = service.delete(noticeIdx);
			
			if(resNoticeDTO == null) {
				// 실패시 409 - 해당 요청의 처리가 비지니스 로직상 불가능하거나 모순이 생긴 경우
				return ResponseEntity
						.status(HttpStatus.CONFLICT)
						.body(null);				
			} else {
				// 성공시 200 - OK
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(resNoticeDTO);
			}

		}
		
		@DeleteMapping("/notice/schedule")
		public void deleteBySchedule(RedirectAttributes rttr) {
			log.info("deleteBySchedule: ");	
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(null); // 수정 필요
		}
}
