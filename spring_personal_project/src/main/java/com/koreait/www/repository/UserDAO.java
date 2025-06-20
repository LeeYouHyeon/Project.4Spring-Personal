package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.AuthVO;
import com.koreait.www.domain.PasswordDTO;
import com.koreait.www.domain.UserVO;

public interface UserDAO {

	int insert(UserVO uvo);

	int insertAuthInit(String id);

	UserVO getUser(String username);

	List<AuthVO> getAuthList(String username);

	int updateLastLogin(String authId);

	int checkUser(String id);

	List<UserVO> getList();

	int grantManager(String id);

	int revokeManager(String id);

	int update(UserVO uvo);

	int changePw(PasswordDTO pdto);

}
