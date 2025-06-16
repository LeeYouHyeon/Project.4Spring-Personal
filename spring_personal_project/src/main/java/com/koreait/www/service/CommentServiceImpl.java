package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.www.domain.CommentVO;
import com.koreait.www.repository.CommentDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

	private final CommentDAO cdao;

	@Override
	public List<CommentVO> getList(long bno) {
		// TODO Auto-generated method stub
		return cdao.getList(bno);
	}

	@Override
	public char[] register(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.register(cvo);
	}
}
