package com.groupware.controller;

import com.groupware.dto.NoticeDTO;
import com.groupware.global.Config;
import com.groupware.global.Sorting;
import com.groupware.service.NoticeService;
import com.groupware.vo.SearchVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/api")
@AllArgsConstructor
@RestController
@Log4j
public class NoticeController {

		private NoticeService service;
		
		@GetMapping("/notice")
		public ResponseEntity<List<NoticeDTO>> list(
				@RequestParam(defaultValue = "") String title,
				@RequestParam(defaultValue = "") String content,
				@RequestParam(defaultValue = "") String writer,
				@RequestParam(defaultValue = "") Integer sorting,
				@RequestParam(defaultValue = "1") Integer page
				) {
			
			int pageSize = Config.globalPageSize;
			SearchVO searchVO = new SearchVO(title, content, writer, sorting, page, pageSize);
			
			System.out.println(searchVO);
			
			List<NoticeDTO> dtos = service.selectList(searchVO);
			
			if(dtos.size() < 1 ) {
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body(dtos);
			} else {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(dtos);
			}
		}

		
		@PostMapping("/notice")
		public String post(NoticeDTO noticeDTO, RedirectAttributes rttr) {
			log.info("post: " + noticeDTO);
			service.insert(noticeDTO);
			rttr.addFlashAttribute("result", noticeDTO.getNoticeIdx());
			
			return "redirect:/notice";
		}
		
		@GetMapping("/notice/{noticeIdx}")
		public String get(@PathVariable("noticeIdx") Long noticeIdx, Model model) {
			log.info("/get");
			model.addAttribute("notice", service.select(noticeIdx));
			
			return "/notice/detailForm"; 
		}
		
		@PutMapping("/notice")
		public String put(NoticeDTO noticeDTO, RedirectAttributes rttr) {
			log.info("put: " + noticeDTO);
			if(service.update(noticeDTO)) {
				rttr.addFlashAttribute("result", noticeDTO.getNoticeIdx());
			}			
			
			return "redirect:/notice";
		}
		
		@DeleteMapping("/notice/{noticeIdx}")		
		public String delete(@PathVariable("noticeIdx") Long noticeIdx, RedirectAttributes rttr) {
			log.info("delete: " + noticeIdx);
			if(service.delete(noticeIdx)) {
				rttr.addFlashAttribute("result", "success");
			}			
			
			return "redirect:/notice";
		}
		
		@DeleteMapping("/notice/schedule")
		public void deleteBySchedule(RedirectAttributes rttr) {
			log.info("deleteBySchedule: ");			
		}
}
