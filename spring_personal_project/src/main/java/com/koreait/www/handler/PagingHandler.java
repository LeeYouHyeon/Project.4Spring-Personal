package com.koreait.www.handler;

import java.util.List;

import com.koreait.www.domain.CommentVO;
import com.koreait.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingHandler {
	private int qty; // 한 페이지에 나오는 페이지네이션 갯수
	private long startPage; // 페이지네이션 시작번호
	private long endPage; // 페이지네이션 끝번호
	private boolean prev; // 이전 여부
	private boolean next; // 다음 여부

	private long totalCount; // 전체 갯수(DB에서 조회)
	private PagingVO pgvo; // 매개변수로 받아옴
	
	private long realEndPage; // 진짜 끝 페이지
	
	// 댓글 페이징을 위한 List<CommentVO> 추가
	private List<CommentVO> cmtList;
	
	// 생성자에서 모든 값을 계산
	public PagingHandler(long totalCount, PagingVO pgvo) {
		this.qty = 10;
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		// 1~10 / 11~20 / 21~30 / ... 
		
		this.endPage = ceil(pgvo.getPageNo(), this.qty)*this.qty;
		this.startPage = this.endPage - this.qty + 1;
		
		// 실제 마지막 수 페이지
		this.realEndPage = ceil(totalCount, pgvo.getQty());
		
		// 이전, 다음 여부
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEndPage;
		
		if (endPage > realEndPage) {
			this.endPage = this.realEndPage;
		}
	}
	
	// 댓글용 생성자
	public PagingHandler(long totalCount, PagingVO pgvo, List<CommentVO> cmtList) {
		this(totalCount, pgvo);
		this.cmtList = cmtList;
	}
	
	private long ceil(long n, long m) {
		return (n - 1)/m + 1;
	}
}
