package com.koreait.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.www.domain.PasswordDTO;
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
	
	@GetMapping("/list")
	public void list(Model m) {
		m.addAttribute("list", usv.getList());
	}
	
	@ResponseBody
	@GetMapping("/toggleManager")
	public String toggleManager(String id) {
		return String.valueOf(usv.toggleManager(id));
	}
	
	@GetMapping("/user/myInfo")
	public void myInfo() {}
	
	@ResponseBody
	@PostMapping("/update")
	public String update(@RequestBody UserVO uvo) {
		log.info(">>>> update uvo >> {}", uvo);
		return String.valueOf(usv.update(uvo));
	}
		
	@GetMapping("/changePw")
	public void changePw() {}
	
	@PostMapping("/changePw")
	public String changePw(@RequestBody PasswordDTO pdto, RedirectAttributes re, HttpServletRequest request, HttpServletResponse response) {
		pdto.setBefore(bcEncoder.encode(pdto.getBefore()));
		pdto.setAfter(bcEncoder.encode(pdto.getAfter()));
		int isOk = usv.changePw(pdto);
		
		re.addFlashAttribute("isOk", isOk);
		String dest = "redirect:/changePw";
		if (isOk > 0) {
			logout(request, response);
			dest = "redirect:/login";
		}
		
		return dest;
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		new SecurityContextLogoutHandler().logout(request, response, authentication);
	}
}
