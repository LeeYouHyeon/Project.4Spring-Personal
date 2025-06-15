<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="my-5">
	<h3 class="text-center">공지사항</h3>
	<!-- search line -->
	<div class="container-md">
		<div class="row mb-3">
			<form class="d-flex" action="/notice/list">
				<div class="col-1">
					<select class="form-select me-2 w-25" name="type" aria-label="Default select example">
						<option ${ph.pgvo.type eq null ? 'selected' : ''}>검색</option>
						<option value="t" ${ph.pgvo.type eq 't' ? 'selected' : ''}>제목</option>
						<option value="tc" ${ph.pgvo.type eq 'tc' ? 'selected' : ''}>제목+내용</option>
						<option value="c" ${ph.pgvo.type eq 'c' ? 'selected' : ''}>내용</option>
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
	
	<div class="container-md border rounded px-5 py-3 mb-3">
		<div class="row fs-5 fw-semibold text-center">
			<div class="col-2">번호</div>
			<div class="col-6">제목</div>
			<div class="col-2">작성일</div>
			<div class="col-2">조회수</div>
		</div>
		<hr>
		<c:forEach items="${list}" var="nvo">
		<div class="row mb-2">
			<div class="col-2 text-center">${nvo.nno}</div>
			<div class="col-6">
				<a href="/board/detail?bno=${nvo.nno}">${nvo.title}</a>
			</div>
			<div class="col-2 text-center">${nvo.regDate}</div>
			<div class="col-2 text-center">${nvo.readCount}</div>
		</div>
		</c:forEach>
	</div>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="pri"/>
		<c:if test="${pri.uvo.authList.stream().anyMatch(a -> a.auth.equals('ROLE_MANAGER')).get()}">
			<div class="d-flex justify-content-end my-3 container-md">
				<a href="/board/register">
					<button type="button" class="btn btn-primary">글쓰기</button>		
				</a>
			</div>
		</c:if>
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