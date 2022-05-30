package com.groupware.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FlowController {
	
	private static final Logger logger = LoggerFactory.getLogger(FlowController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String noticeList() {
		return "/notice/list";
	}	
	@RequestMapping(value = "/notice/{noticeIdx}", method = RequestMethod.GET)
	public String notice(@PathVariable("noticeIdx") Long noticeIdx, Model model) {
		model.addAttribute("noticeIdx",noticeIdx);
		return "/notice/view";
	}
	@RequestMapping(value = "/notice/modify/{noticeIdx}", method = RequestMethod.GET)
	public String noticeModify(@PathVariable("noticeIdx") Long noticeIdx, Model model) {
		model.addAttribute("noticeIdx",noticeIdx);
		return "/notice/modify";
	}
	
	@RequestMapping(value = "/notice/register", method = RequestMethod.GET)
	public String noticeRegister() {
		return "/notice/register";
	}	
}
