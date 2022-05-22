package com.groupware.controller;

import com.groupware.service.NoticeService;
import com.groupware.vo.NoticeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/notice")
@AllArgsConstructor
public class NoticeController {

		private NoticeService service;
		
		@GetMapping("/")
		public String list(Model model) {
			log.info("list");
			model.addAttribute("list", service.getNoticeList());
			
			return "/notice/list";
		}
		
		@GetMapping("/newnotice")
		public String insert() {
			return "/notice/insertForm"; 
		}
		
		@PostMapping("/notice")
		public String register(NoticeVO noticeVO, RedirectAttributes rttr) {
			log.info("newnoteice: " + noticeVO);
			service.insert(noticeVO);
			rttr.addFlashAttribute("result", noticeVO.getNoticeIdx());
			
			return "redirect:/notice";
		}
		
		@GetMapping("/notice/{notice_idx}")
		public String get(@RequestParam("notice_idx") Long notice_idx, Model model) {
			log.info("/get");
			model.addAttribute("notice", service.getNotice(notice_idx));
			
			return "/notice/detailForm"; 
		}
		
		@PutMapping("/notice")
		public String update(NoticeVO noticeVO, RedirectAttributes rttr) {
			log.info("update: " + noticeVO);
			if(service.update(noticeVO)) {
				rttr.addFlashAttribute("result", noticeVO.getNoticeIdx());
			}			
			
			return "redirect:/notice";
		}
		
		@DeleteMapping("/notice/{notice_idx}")		
		public String delete(@RequestParam("notice_idx") Long notice_idx, RedirectAttributes rttr) {
			log.info("delete: " + notice_idx);
			if(service.delete(notice_idx)) {
				rttr.addFlashAttribute("result", "success");
			}			
			
			return "redirect:/notice";
		}
}
