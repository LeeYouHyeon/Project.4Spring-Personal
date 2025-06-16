<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="my-3">
	<sec:authentication property="principal" var="pri"/>
	<div class="container-md w-25 border rounded p-3 bg-body-tertiary">
		<h4 class="mb-3 text-center">개인정보</h4>
		<div class="row mb-3">
			<div class="col-1"></div>
			<div class="col-2 d-flex align-items-center">아이디</div>
			<div class="col-9 d-flex align-items-center">${pri.uvo.id}</div>
		</div>
		<div class="row mb-3">
			<div class="col-1"></div>
			<div class="col-2 d-flex align-items-center">이름</div>
			<div class="col-9 d-flex align-items-center" id="nickPrint">${pri.uvo.name}</div>
			<div class="col-9 d-none align-items-center" id="nickInputArea">
				<input type="text"
					name="name"
					id="nickInput"
					class="form-control"
					placeholder="최대 256자"
         			value="${pri.uvo.name}"
					required>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-1"></div>
			<div class="col-2 d-flex align-items-center">이메일</div>
			<div class="col-9 d-flex align-items-center" id="emailPrint">${pri.uvo.email eq null ? '-' : pri.uvo.email}</div>
			<div class="col-9 d-none align-items-center" id="emailInputArea">
				<input type="text"
			      name="email"
			      id="emailInput"
			      class="form-control"
			      value="${pri.uvo.email == '-' ? '' : pri.uvo.email}">
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-1"></div>
			<div class="col-2 d-flex align-items-center">가입일</div>
			<div class="col-9 d-flex align-items-center">${pri.uvo.regDate}</div>
		</div>
		<div class="row d-flex justify-content-evenly" id="defaultBtnArea">
			<a href="/board/list?type=i&keyword=${pri.uvo.id}" class="w-auto">
				<button type="button" class="btn btn-outline-secondary">내가 쓴 글</button>
			</a>
			<a href="/user/changePw" class="w-auto">
				<button type="button" class="btn btn-warning">비밀번호 변경</button>
			</a>
			<button type="button" class="btn btn-secondary w-auto" id="infoModifyBtn">개인정보 수정</button>
		</div>
		<div class="row justify-content-evenly d-none" id="infoUpdateBtnArea">
			<button type="button" class="btn btn-warning w-auto" id="cancelBtn">취소</button>
			<button type="button" class="btn btn-primary w-auto" id="updateBtn">수정</button>
		</div>
	</div>
	<script type="text/javascript">
		const id = `<c:out value="${pri.uvo.id}" />`;
	</script>
	<script type="text/javascript" src="/resources/js/myInfo.js"></script>
</div>
<%@ include file="../layout/footer.jsp" %>