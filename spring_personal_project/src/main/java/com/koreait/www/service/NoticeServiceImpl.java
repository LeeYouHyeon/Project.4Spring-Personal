package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<NoticeVO> getCurrentNotices() {
		// TODO Auto-generated method stub
		return ndao.getCurrentNotices();
	}
	
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

	@Transactional
	@Override
	public long insert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		int isOk = ndao.insert(nvo);
		if (isOk == 0) return 0;
		return ndao.getLast();
	}

	@Override
	public NoticeVO getDetail(long nno, boolean increaseRC) {
		// TODO Auto-generated method stub
		if (increaseRC) ndao.increaseRC(nno);
		return ndao.getDetail(nno);
	}

	@Override
	public NoticeVO getBefore(long nno) {
		// TODO Auto-generated method stub
		return ndao.getBefore(nno);
	}

	@Override
	public NoticeVO getNext(long nno) {
		// TODO Auto-generated method stub
		return ndao.getNext(nno);
	}

	@Override
	public int update(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return ndao.update(nvo);
	}
}
