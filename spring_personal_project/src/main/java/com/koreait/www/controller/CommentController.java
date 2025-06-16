package com.koreait.www.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.www.domain.CommentVO;
import com.koreait.www.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/comment/*")
@RequiredArgsConstructor
@Slf4j
@RestController
public class CommentController {

	private final CommentService csv;
	private final BCryptPasswordEncoder bc;
	
	@ResponseBody
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CommentVO> list(long bno) {
		return csv.getList(bno);
	}
	
	@ResponseBody
	@PostMapping("/register")
	public String register(@RequestBody CommentVO cvo) {
		if (cvo.getPwd() != null) cvo.setPwd(bc.encode(cvo.getPwd()));
		return String.valueOf(csv.register(cvo));
	}
}
