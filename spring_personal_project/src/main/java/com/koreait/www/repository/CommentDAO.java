package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.CommentVO;

public interface CommentDAO {

	List<CommentVO> getList(long bno);

	char[] register(CommentVO cvo);

}
