package com.koreait.www.service;

import java.util.List;

import com.koreait.www.domain.PasswordDTO;
import com.koreait.www.domain.UserVO;

public interface UserService {

	int insert(UserVO uvo);

	int isRegistered(String id);

	List<UserVO> getList();

	int toggleManager(String id);

	int update(UserVO uvo);

	int changePw(PasswordDTO pdto);

}
