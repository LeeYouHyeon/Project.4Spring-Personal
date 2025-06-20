package com.koreait.www.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.IBVO;
import com.koreait.www.domain.NoticeVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.handler.PagingHandler;
import com.koreait.www.service.BoardService;
import com.koreait.www.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class BoardController {

	private final BoardService bsv;
	
	private final NoticeService nsv;
	
	// 게시판
	@GetMapping("/list")
	public void list(Model m, PagingVO pgvo) {
		List<BoardVO> list = bsv.getList(pgvo);
		List<NoticeVO> notices = nsv.getCurrentNotices();
		
		long totalCount = bsv.getTotalCount(pgvo);
		PagingHandler ph = new PagingHandler(totalCount, pgvo);
		
		m.addAttribute("ph", ph);
		m.addAttribute("list", list);
		m.addAttribute("notices", notices);
	}
	
	@GetMapping("/bookmark")
	public void bookmark(Model m) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		m.addAttribute("list", bsv.getBookmarked(authentication.getName()));
	}
	
	@GetMapping("/register")
	public void register() {}
	
	@ResponseBody
	@PostMapping("/register")
	public String register(@RequestBody BoardVO bvo) {
		log.info(">>>> bvo >> {}", bvo);
		long bno = bsv.insert(bvo);
		log.info(">>>> bno >> " + bno);
		return String.valueOf(bno);
	}
	
	@GetMapping("/detail")
	public void detail(long bno, Model m, String update) {
		m.addAttribute("bvo", bsv.getDetail(bno, update == null));
		m.addAttribute("next", bsv.getNext(bno));
		m.addAttribute("before", bsv.getBefore(bno));
	}
	
	@GetMapping("/modify")
	public String modify(long bno, String id, Model m) {
		if (!bsv.checkID(bno, id)) return "redirect:/board/list";
		
		m.addAttribute("bvo", bsv.getDetail(bno, false));
		return "/board/modify";
	}
	
	@ResponseBody
	@PostMapping("/update")
	public String update(@RequestBody BoardVO bvo) {
		return String.valueOf(bsv.update(bvo));
	}
	
	@GetMapping(value = "/hots", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BoardVO>> hots() {
		return new ResponseEntity<List<BoardVO>>(bsv.getHots(), HttpStatus.OK);
	}
	
//	좋아요/싫어요
	@ResponseBody
	@GetMapping("/board/getLike")
	public String getLike(IBVO ibvo) {
		return String.valueOf(bsv.getLike(ibvo));
	}
	
	@ResponseBody
	@GetMapping("/board/getDislike")
	public String getDislike(IBVO ibvo) {
		return String.valueOf(bsv.getDislike(ibvo));
	}
	
	@ResponseBody
	@GetMapping("/board/getLikeCount")
	public String getLikeCount(long bno) {
		return String.valueOf(bsv.getLikeCount(bno));
	}
	
	@ResponseBody
	@GetMapping("/board/getDislikeCount")
	public String getDislikeCount(long bno) {
		return String.valueOf(bsv.getDislikeCount(bno));
	}
	
	@ResponseBody
	@GetMapping("/board/toggleLike")
	public String toggleLike(IBVO ibvo) {
		return String.valueOf(bsv.toggleLike(ibvo));
	}
	
	@ResponseBody
	@GetMapping("/board/toggleDislike")
	public String toggleDislike(IBVO ibvo) {
		return String.valueOf(bsv.toggleDislike(ibvo));
	}
	
//	북마크
	@ResponseBody
	@GetMapping("/board/getBookmark")
	public String getBookmark(IBVO ibvo) {
		return String.valueOf(bsv.getBookmark(ibvo));
	}
	
	@ResponseBody
	@GetMapping("/board/toggleBookmark")
	public String toggleBookmark(IBVO ibvo) {
		return String.valueOf(bsv.toggleBookmark(ibvo));
	}
}
