package com.koreait.www.service;

import java.util.List;

import com.koreait.www.domain.CommentVO;

public interface CommentService {

	List<CommentVO> getList(long bno);

	int register(CommentVO cvo);

}
