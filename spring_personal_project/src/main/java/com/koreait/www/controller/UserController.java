package com.koreait.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.www.domain.UserVO;
import com.koreait.www.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/user/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class UserController {

	private final UserService usv;
	private final BCryptPasswordEncoder bcEncoder;
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, RedirectAttributes re) {
		// 로그인 실패 상태
		re.addAttribute("errmsg", request.getAttribute("errmsg"));
		return "redirect:/user/login";
	}
	
	@GetMapping("/register")
	public void register() {}

	@ResponseBody
	@GetMapping("/check/{id}")
	public String isRegistered(@PathVariable(name = "id") String id) {
		return String.valueOf(usv.isRegistered(id));
	}
	
	@PostMapping("/register")
	public String register(UserVO uvo, RedirectAttributes re) {
		uvo.setPw(bcEncoder.encode(uvo.getPw()));
		int isOk = usv.insert(uvo);
		log.info("user register >>", isOk > 0 ? "성공" : "실패");
		
		re.addAttribute("isOk", String.valueOf(isOk));
		return "redirect:/user/registerResult";
	}
	
	@GetMapping("/registerResult")
	public void registerResult() {}
	
}
