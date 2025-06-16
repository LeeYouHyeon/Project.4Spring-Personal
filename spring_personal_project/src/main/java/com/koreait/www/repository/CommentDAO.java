package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.CommentVO;

public interface CommentDAO {

	List<CommentVO> getList(long bno);

	int registerAnonymous(CommentVO cvo);
	
	int registerAuthenticated(CommentVO cvo);
}
