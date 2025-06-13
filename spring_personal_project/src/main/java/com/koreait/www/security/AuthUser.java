package com.koreait.www.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.koreait.www.domain.UserVO;

import lombok.Getter;

public class AuthUser extends User {

	private static final long serialVersionUID = 1L;

	@Getter
	private UserVO uvo;
	
	public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public AuthUser(UserVO uvo) {
		super(uvo.getId(), uvo.getPw(),
				uvo.getAuthList()
					.stream()
					.map(a -> new SimpleGrantedAuthority(a.getAuth()))
					.collect(Collectors.toList()));
		this.uvo = uvo;
	}
	
}
