package com.koreait.www.service;

import java.util.List;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.IBVO;
import com.koreait.www.domain.PagingVO;

public interface BoardService {
//	게시판
	List<BoardVO> getList(PagingVO pgvo);

	long getTotalCount(PagingVO pgvo);

	long insert(BoardVO bvo);

	BoardVO getDetail(long bno, boolean increase);

	boolean checkID(long bno, String id);
	
	int update(BoardVO bvo);
	
	BoardVO getBefore(long bno);

	BoardVO getNext(long bno);
	
	List<BoardVO> getHots();
	
//	좋아요, 싫어요
	long getLikeCount(long bno);

	long getDislikeCount(long bno);

	int getLike(IBVO ibvo);
	
	int getDislike(IBVO ibvo);
	
	int toggleLike(IBVO ibvo);

	int toggleDislike(IBVO ibvo);

	
//	북마크
	int getBookmark(IBVO ibvo);
	
	int toggleBookmark(IBVO ibvo);

	List<BoardVO> getBookmarked(String id);

}
