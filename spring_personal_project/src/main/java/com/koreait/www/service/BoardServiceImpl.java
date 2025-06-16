package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.IBVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.repository.BoardDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDAO bdao;

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getList(pgvo);
	}

	@Override
	public long getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getTotalCount(pgvo);
	}

	@Override
	public long insert(BoardVO bvo) {
		// TODO Auto-generated method stub
		int isOk = bdao.insert(bvo);
		if (isOk == 0) return 0;
		return bdao.getLastBno();
	}

	@Override
	public BoardVO getDetail(long bno, boolean increase) {
		// TODO Auto-generated method stub
		if (increase) bdao.increaseRead(bno);
		return bdao.getDetail(bno);
	}

	@Override
	public boolean checkID(long bno, String id) {
		// TODO Auto-generated method stub
		return bdao.getId(bno).equals(id);
	}
	
	@Override
	public int update(BoardVO bvo) {
		// TODO Auto-generated method stub
		return bdao.update(bvo);
	}
	
	@Override
	public BoardVO getBefore(long bno) {
		// TODO Auto-generated method stub
		return bdao.getBefore(bno);
	}

	@Override
	public BoardVO getNext(long bno) {
		// TODO Auto-generated method stub
		return bdao.getNext(bno);
	}

	@Override
	public long getLikeCount(long bno) {
		// TODO Auto-generated method stub
		return bdao.getLikeCount(bno);
	}

	@Override
	public long getDislikeCount(long bno) {
		// TODO Auto-generated method stub
		return bdao.getDislikeCount(bno);
	}
	
	@Override
	public int getLike(IBVO ibvo) {
		// TODO Auto-generated method stub
		return bdao.getLike(ibvo);
	}
	
	@Override
	public int getDislike(IBVO ibvo) {
		// TODO Auto-generated method stub
		return bdao.getDislike(ibvo);
	}

	@Transactional
	@Override
	public int toggleLike(IBVO ibvo) {
		// TODO Auto-generated method stub
		if(bdao.getLike(ibvo) == 0) {
			bdao.insertLike(ibvo);
			bdao.updateLike(ibvo.getBno(), 1);
			return 1;
		} else {
			bdao.removeLike(ibvo);
			bdao.updateLike(ibvo.getBno(), -1);
			return -1;
		}
	}

	@Transactional
	@Override
	public int toggleDislike(IBVO ibvo) {
		if (bdao.getDislike(ibvo) == 0) {
			bdao.insertDislike(ibvo);
			bdao.updateDislike(ibvo.getBno(), 1);
			return 1;
		} else {
			bdao.removeDislike(ibvo);
			bdao.updateDislike(ibvo.getBno(), -1);
			return -1;
		}
	}

	@Override
	public int getBookmark(IBVO ibvo) {
		// TODO Auto-generated method stub
		return bdao.getBookmark(ibvo);
	}


	@Override
	public int toggleBookmark(IBVO ibvo) {
		// TODO Auto-generated method stub
		if (getBookmark(ibvo) == 0) {
			bdao.insertBookmark(ibvo);
			return 1;
		} else {
			bdao.removeBookmark(ibvo);
			return -1;
		}
	}

	@Override
	public List<BoardVO> getHots() {
		// TODO Auto-generated method stub
		return bdao.getHots();
	}

	@Override
	public List<BoardVO> getBookmarked(String id) {
		// TODO Auto-generated method stub
		return bdao.getBookmarks(id);
	}
	
}
