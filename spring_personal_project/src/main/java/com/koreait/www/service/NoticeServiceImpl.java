package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.www.domain.NoticeVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.repository.NoticeDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

	private final NoticeDAO ndao;

	@Override
	public List<NoticeVO> getList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return ndao.getList(pgvo);
	}

	@Override
	public long getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return ndao.getTotalCount(pgvo);
	}

	@Override
	public long insert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return ndao.insert(nvo);
	}

	@Override
	public NoticeVO getDetail(long nno) {
		// TODO Auto-generated method stub
		return ndao.getDetail(nno);
	}
}
