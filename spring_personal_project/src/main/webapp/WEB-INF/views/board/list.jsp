<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="my-5">
	<h3 class="text-center">게시판</h3>
	<div class="container-md">
		<!-- search line -->
		<div class="row mb-3">
			<form class="d-flex" action="/board/list">
				<div class="col-1">
					<select class="form-select me-2 w-25" name="type" aria-label="Default select example">
						<option ${ph.pgvo.type eq null ? 'selected' : ''}>검색</option>
						<option value="t" ${ph.pgvo.type eq 't' ? 'selected' : ''}>제목</option>
						<option value="tc" ${ph.pgvo.type eq 'tc' ? 'selected' : ''}>제목+내용</option>
						<option value="c" ${ph.pgvo.type eq 'c' ? 'selected' : ''}>내용</option>
						<option value="w" ${ph.pgvo.type eq 'w' ? 'selected' : ''}>작성자</option>
					</select>
				</div>
				<div class="col-4">
					<input class="form-control me-2"
						name="keyword"
						type="search"
						placeholder="Search"
						aria-label="Search"
						aria-describedby="search-addon"
						value="${ph.pgvo.keyword}"
						required>
				</div>
				<input type="hidden" name="pageNo" value="1">
				<input type="hidden" name="qty" value="${ph.pgvo.qty}">
				<div class="col-1">
					<button type="submit" class="btn btn-success">검색</button>				
				</div>
			</form>
			<c:choose>
				<c:when test="${ph.pgvo.type eq null}">
					<div class="col-6"></div>
				</c:when>
				<c:otherwise>
					<div class="col-5 text-right">
						검색 결과 ${ph.totalCount} 건
					</div>
					<div class="col-1">
						<a href="/notice/list">
							<button type="button" class="btn btn-secondary">검색 취소</button>
						</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<div class="row fs-5 fw-semibold text-center">
		<div class="col-1">번호</div>
		<div class="col-5">제목</div>
		<div class="col-2">작성자</div>
		<div class="col-3">작성일</div>
		<div class="col-1">조회수</div>
	</div>
	
	<div class="container-md border rounded px-5 py-3 mb-3">
		<hr>
		<c:forEach items="${list}" var="bvo">
		<div class="row mb-2">
			<div class="col-1">${bvo.bno}</div>
			<div class="col-5">
				<a href="/board/detail?bno=${bvo.bno}">${bvo.title}</a>
				<span class="text-danger fw-bold">[${bvo.cmtCount}]</span>
			</div>
			<div class="col-2">${bvo.name}</div>
			<div class="col-3">${bvo.regDate}</div>
			<div class="col-1">${bvo.readCount}</div>
		</div>
		</c:forEach>
	</div>
	<sec:authorize access="isAuthenticated()">
	<div class="d-flex justify-content-end my-3 container-md">
		<a href="/board/register">
			<button type="button" class="btn btn-primary">글쓰기</button>		
		</a>
	</div>	
	</sec:authorize>

	<!-- paging area -->
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<li class="page-item">
				<a class="page-link ${ph.prev ? '' : 'disabled'}"
					href="/board/list?pageNo=${ph.startPage - 1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"
					aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>

			<c:forEach var="i" begin="${ph.startPage}" end="${ph.endPage}">
				<li class="page-item">
					<a class="page-link ${ph.pgvo.pageNo == i ? 'active' : ''}"
						href="/board/list?pageNo=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">
						${i}
					</a>
				</li>
			</c:forEach>

			<li class="page-item">
				<a class="page-link ${ph.next ? '' : 'disabled'}"
					href="/board/list?pageNo=${ph.endPage + 1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"
					aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</ul>
	</nav>
</div>
<%@ include file="../layout/footer.jsp" %>