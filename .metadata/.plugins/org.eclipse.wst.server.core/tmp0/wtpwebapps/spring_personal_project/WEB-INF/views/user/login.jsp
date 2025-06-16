<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container-md mb-5 w-25 position-relative">
	<c:if test="${isOk ne null}">
		<span class="badge text-bg-success position-absolute top-0 start-50 translate-middle-x">
			비밀번호가 변경되었습니다. 다시 로그인해주세요.
		</span>
	</c:if>
	<form action="/user/login" method="post" class="mt-5 p-5 pb-4 bg-info-subtle rounded border">
		<div class="row mb-3">
			<div class="col-3 d-flex align-items-center">아이디</div>
			<div class="col-9">
				<input type="text" name="id" class="form-control">
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-3 d-flex align-items-center">비밀번호</div>
			<div class="col-9">
				<input type="password" name="pw" class="form-control">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col d-flex justify-content-center align-items-center">
				<button type="submit" class="btn btn-primary">로그인</button>
			</div>
		</div>
		<div class="row">
			<div class="col-8 d-flex justify-content-center align-items-center">아직 회원이 아니신가요?</div>
			<div class="col-4">
				<a href="/user/register">
					<button type="button" class="btn btn-secondary">회원가입</button>
				</a>
			</div>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp" %>