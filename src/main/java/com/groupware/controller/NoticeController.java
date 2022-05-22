package com.groupware.controller;

import com.groupware.service.NoticeService;
import com.groupware.vo.NoticeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/notice/*")
@AllArgsConstructor
public class NoticeController {

		private NoticeService service;
		
		@GetMapping("/list")
		public void list(Model model) {
			log.info("list");
			model.addAttribute("list", service.getNoticeList());
		}
		
		@GetMapping("/insert")
		public void insert() {

		}
		
		@PostMapping("/insert")
		public String register(NoticeVO noticeVO, RedirectAttributes rttr) {
			log.info("insert: " + noticeVO);
			service.insert(noticeVO);
			rttr.addFlashAttribute("result", noticeVO.getNoticeIdx());
			
			return "redirect:/notice/list";
		}
		
		@GetMapping("/get")
		public void get(@RequestParam("notice_idx") Long notice_idx, Model model) {
			log.info("/get");
			model.addAttribute("notice", service.getNotice(notice_idx));
		}
		
		@PostMapping("/update")
		public String update(NoticeVO noticeVO, RedirectAttributes rttr) {
			log.info("update: " + noticeVO);
			if(service.update(noticeVO)) {
				rttr.addFlashAttribute("result", noticeVO.getNoticeIdx());
			}			
			
			return "redirect:/notice/list";
		}
		
		@PostMapping("/delete")
		public String delete(@RequestParam("notice_idx") Long notice_idx, RedirectAttributes rttr) {
			log.info("delete: " + notice_idx);
			if(service.delete(notice_idx)) {
				rttr.addFlashAttribute("result", "success");
			}			
			
			return "redirect:/notice/list";
		}
}
