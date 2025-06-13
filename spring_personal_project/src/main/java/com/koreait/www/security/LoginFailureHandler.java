package com.koreait.www.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// 로그인에 실패하면 request에 로그인 시도 객체가 남음
		String authId = request.getParameter("id");
		String errorMessage = null;
		
		log.info(">>>> failure exception >> {}", exception.getMessage().toString());
		if (exception instanceof UsernameNotFoundException) {
			errorMessage = "이메일을 찾을 수 없습니다.";
		} else if (exception instanceof BadCredentialsException) {
			errorMessage = "비밀번호가 일치하지 않습니다.";
		} else if (exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "내부 서버 오류입니다. 관리자에게 문의하세요.";
		} else {
			errorMessage = "알 수 없는 오류입니다. 관리자에게 문의하세요.";
		}
		
		request.setAttribute("id", authId);
		request.setAttribute("errmsg", errorMessage);
		
		request.getRequestDispatcher("/user/login").forward(request, response);
	}

}
