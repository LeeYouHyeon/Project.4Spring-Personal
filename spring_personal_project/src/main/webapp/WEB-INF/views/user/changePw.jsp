<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="my-3">
	<sec:authentication property="principal" var="pri"/>
	<div class="container-md border rounded p-3 bg-body-tertiary position-relative w-50">
		<c:if test="${isOk ne null}">
			<span class="badge text-bg-danger position-absolute top-0 start-50 translate-middle-x">
				<c:if test="${isOk eq '-1'}">기존 비밀번호가 맞지 않습니다.</c:if>
				<c:if test="${isOk eq '0'}">오류가 발생했습니다. 다시 시도해주세요.</c:if>
			</span>
		</c:if>
		<h4 class="text-center mb-3">비밀번호 변경</h4>
		<form action="/user/changePw" method="post">
			<div class="row mb-3 ms-2">
				<div class="col-2 d-flex align-items-center">기존 비밀번호</div>
				<div class="col-3">
					<input type="password" class="form-control" name="prev" id="prev">
				</div>
				<div class="col-7"></div>
			</div>
			<div class="row mb-3 ms-2">
				<div class="col-2 d-flex align-items-center">새 비밀번호</div>
				<div class="col-3">
					<input type="password" class="form-control" name="newPw" id="newPw">
				</div>
				<div class="col-7 d-flex align-items-center" id="validationArea"></div>
			</div>
			<div class="row mb-3 ms-2">
				<div class="col-2 d-flex align-items-center">비밀번호 확인</div>
				<div class="col-3">
					<input type="password" class="form-control" name="newCheck" id="newCheck">
				</div>
				<div class="col-7 d-flex align-items-center" id="matchArea"></div>
			</div>
			<div class="d-flex justify-content-end">
				<a href="/user/myInfo" class="me-3">
					<button type="button" class="btn btn-secondary">취소</button>
				</a>
				<button type="button" class="btn btn-warning" id="changeBtn">비밀번호 변경</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		const id = `<c:out value="${pri.uvo.id}" />`;
	</script>
	<script type="text/javascript" src="/resources/js/changePw.js"></script>
</div>
<%@ include file="../layout/footer.jsp" %>