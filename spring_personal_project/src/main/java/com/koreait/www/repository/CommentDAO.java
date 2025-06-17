package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.CommentVO;

public interface CommentDAO {

	List<CommentVO> getList(long bno);

	int registerAnonymous(CommentVO cvo);
	
	int registerAuthenticated(CommentVO cvo);

	CommentVO getOne(long cno);

	int remove(long cno);

	int update(CommentVO cvo);
}
