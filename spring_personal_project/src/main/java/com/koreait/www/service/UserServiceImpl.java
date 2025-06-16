package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.www.domain.AuthVO;
import com.koreait.www.domain.PasswordDTO;
import com.koreait.www.domain.UserVO;
import com.koreait.www.repository.UserDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private final UserDAO udao;
	
	@Transactional
	@Override
	public int insert(UserVO uvo) {
		// TODO Auto-generated method stub
		int isOk = udao.insert(uvo);
		if (isOk == 0) return 0;
		
		return udao.insertAuthInit(uvo.getId());
	}

	@Override
	public int isRegistered(String id) {
		return udao.checkUser(id);
	}

	@Override
	public List<UserVO> getList() {
		// TODO Auto-generated method stub
		List<UserVO> users = udao.getList();
		for (UserVO uvo : users) {
			uvo.setAuthList(udao.getAuthList(uvo.getId()));
		}
		return users;
	}

	@Override
	public int toggleManager(String id) {
		// TODO Auto-generated method stub
		List<AuthVO> authList = udao.getAuthList(id);
		for (AuthVO auth : authList)
			if (auth.getAuth().equals("ROLE_MANAGER"))
				return udao.revokeManager(id);
		return udao.grantManager(id);
	}

	@Override
	public int update(UserVO uvo) {
		// TODO Auto-generated method stub
		return udao.update(uvo);
	}

	@Override
	public int changePw(PasswordDTO pdto) {
		// TODO Auto-generated method stub
		UserVO uvo = udao.getUser(pdto.getId());
		if (uvo.getPw() != pdto.getBefore()) return -1;
		return udao.changePw(pdto);
	}
	
}
