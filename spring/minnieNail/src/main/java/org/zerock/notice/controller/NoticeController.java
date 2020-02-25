package org.zerock.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {

	@RequestMapping(value = "/notice/list.do", method = RequestMethod.GET)
	public String list() {
		return "notice/list";
	}
	@RequestMapping(value = "/notice/view.do", method = RequestMethod.GET)
	public String view() {
		return "notice/view";
	}
	@RequestMapping(value = "/notice/write.do", method = RequestMethod.GET)
	public String writeForm() {
		return "notice/write";
	}
	@RequestMapping(value = "/notice/write.do", method = RequestMethod.POST)
	public String write() {
		return "notice/write";
	}
	@RequestMapping(value = "/notice/update.do", method = RequestMethod.GET)
	public String updateForm() {
		return "notice/update";
	}
	@RequestMapping(value = "/notice/update.do", method = RequestMethod.POST)
	public String update() {
		return "notice/update";
	}
	@RequestMapping(value = "/notice/delete.do", method = RequestMethod.POST)
	public String delete() {
		return "notice/delete";
	}
}
