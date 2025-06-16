package com.koreait.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.IBVO;
import com.koreait.www.domain.PagingVO;

public interface BoardDAO {
//	게시판
	List<BoardVO> getList(PagingVO pgvo);

	long getTotalCount(PagingVO pgvo);

	int insert(BoardVO bvo);

	long getLastBno();

	BoardVO getDetail(long bno);

	void increaseRead(long bno);
	
	String getId(long bno);
	
	int update(BoardVO bvo);
	
	BoardVO getBefore(long bno);
	
	BoardVO getNext(long bno);
	
	List<BoardVO> getHots();
	
//	좋아요/싫어요
	long getLikeCount(long bno);

	long getDislikeCount(long bno);

	int getLike(IBVO ibvo);

	int getDislike(IBVO ibvo);

	int insertLike(IBVO ibvo);

	int removeLike(IBVO ibvo);

	int insertDislike(IBVO ibvo);

	int removeDislike(IBVO ibvo);

	void updateLike(@Param("bno") long bno, @Param("i") int i);
	
	void updateDislike(@Param("bno") long bno, @Param("i") int i);
	
//	북마크
	int getBookmark(IBVO ibvo);

	int insertBookmark(IBVO ibvo);

	int removeBookmark(IBVO ibvo);

	List<BoardVO> getBookmarks(String id);

}
