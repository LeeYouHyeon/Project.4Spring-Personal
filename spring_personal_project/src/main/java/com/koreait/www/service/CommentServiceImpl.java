package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.www.domain.CommentVO;
import com.koreait.www.repository.BoardDAO;
import com.koreait.www.repository.CommentDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

	private final CommentDAO cdao;
	
	private final BoardDAO bdao;

	@Override
	public List<CommentVO> getList(long bno) {
		// TODO Auto-generated method stub
		return cdao.getList(bno);
	}
	
	@Transactional
	@Override
	public int register(CommentVO cvo) {
		// TODO Auto-generated method stub
		int isOk = cvo.getPwd() == null ? cdao.registerAuthenticated(cvo) : cdao.registerAnonymous(cvo);
		if (isOk == 0) return 0;
		return bdao.increaseCmtCount(cvo.getBno());
	}
}
