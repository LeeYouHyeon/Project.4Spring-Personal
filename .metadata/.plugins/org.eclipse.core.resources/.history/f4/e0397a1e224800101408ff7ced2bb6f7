package com.koreait.www.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.www.domain.NoticeVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.handler.PagingHandler;
import com.koreait.www.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/notice/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class NoticeController {
	
	private final NoticeService nsv;
	
	@GetMapping("/list")
	public void list(Model m, PagingVO pgvo) {
		List<NoticeVO> list = nsv.getList(pgvo);
		
		long totalCount = nsv.getTotalCount(pgvo);
		PagingHandler ph = new PagingHandler(totalCount, pgvo);
		
		m.addAttribute("ph", ph);
		m.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void register() {}
	
	@ResponseBody
	@PostMapping("/register")
	public String register(@RequestBody NoticeVO nvo) {
		long nno = nsv.insert(nvo);
		return String.valueOf(nno);
	}
	
	@GetMapping("/detail")
	public void detail(long nno, Model m) {
		m.addAttribute("nvo", nsv.getDetail(nno));
	}
}
