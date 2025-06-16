package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.NoticeVO;
import com.koreait.www.domain.PagingVO;

public interface NoticeDAO {

	List<NoticeVO> getList(PagingVO pgvo);

	long getTotalCount(PagingVO pgvo);

	int insert(NoticeVO nvo);

	long getLast();
	
	NoticeVO getDetail(long nno);

	List<NoticeVO> getCurrentNotices();

	void increaseRC(long nno);

	NoticeVO getBefore(long nno);

	NoticeVO getNext(long nno);

	int update(NoticeVO nvo);

}
