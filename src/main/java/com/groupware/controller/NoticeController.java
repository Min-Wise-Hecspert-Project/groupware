package com.groupware.controller;

import com.groupware.dto.NoticeDTO;
import com.groupware.service.NoticeService;

import java.util.List;

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
@Log4j
@RequestMapping("/notice")
@AllArgsConstructor
@RestController
public class NoticeController {

		private NoticeService service;
		
		@GetMapping("")
		public List<NoticeDTO> list(Model model) {
			log.info("list");
			
			return service.getNoticeList();
		}
		
		@GetMapping("/new")
		public String insert() {
			return "/notice/insertForm";
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
			model.addAttribute("notice", service.getNotice(noticeIdx));
			
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
		public String delete(@RequestParam("noticeIdx") Long noticeIdx, RedirectAttributes rttr) {
			log.info("delete: " + noticeIdx);
			if(service.delete(noticeIdx)) {
				rttr.addFlashAttribute("result", "success");
			}			
			
			return "redirect:/notice";
		}
}
