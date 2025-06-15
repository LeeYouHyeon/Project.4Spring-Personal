package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.NoticeVO;
import com.koreait.www.domain.PagingVO;

public interface NoticeDAO {

	List<NoticeVO> getList(PagingVO pgvo);

	long getTotalCount(PagingVO pgvo);

	long insert(NoticeVO nvo);

	NoticeVO getDetail(long nno);

	List<NoticeVO> getCurrentNotices();

}
