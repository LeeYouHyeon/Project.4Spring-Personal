<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="my-3">
	<h4 class="text-center mb-3">즐겨찾기</h4>
	<div class="container-md border rounded px-5 py-3 mb-3">
		<div class="row fs-5 fw-semibold text-center">
			<div class="col-1">번호</div>
			<div class="col-4">제목</div>
			<div class="col-2">작성자</div>
			<div class="col-3">작성일</div>
			<div class="col-1">조회수</div>
			<div class="col-1">좋아요</div>
		</div>
		<hr>
		<c:forEach items="${list}" var="bvo">
		<div class="row mb-2">
			<div class="col-1 text-center">${bvo.bno}</div>
			<div class="col-4">
				<a href="/board/detail?bno=${bvo.bno}">${bvo.title}</a>
				<span class="text-danger fw-bold">[${bvo.cmtCount}]</span>
			</div>
			<div class="col-2 text-center">${bvo.name}</div>
			<div class="col-3 text-center">${bvo.regDate}</div>
			<div class="col-1 text-center">${bvo.readCount}</div>
			<div class="col-1 text-center">${bvo.likes}</div>
		</div>
		</c:forEach>
	</div>
</div>
<%@ include file="../layout/footer.jsp" %>