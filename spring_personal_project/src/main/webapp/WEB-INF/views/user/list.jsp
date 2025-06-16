<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="my-3">
	<h3 class="text-center">사용자 목록</h3>
	<div class="container-md text-center">
		<div class="row my-3">
			<div class="col-2">아이디</div>
			<div class="col-2">이름</div>
			<div class="col-3">이메일</div>
			<div class="col-3">가입일</div>
			<div class="col-2">관리자</div>
		</div>
		<c:forEach items="${list}" var="uvo">
			<div class="row mb-3">
				<div class="col-2">${uvo.id}</div>
				<div class="col-2">${uvo.name}</div>
				<div class="col-3">
					${uvo.email eq null ? '-' : uvo.email} 
				</div>
				<div class="col-3">${uvo.regDate}</div>
				<div class="col-2 d-flex justify-content-center align-items-center">
					<c:choose>
						<c:when test="${uvo.authList.stream().anyMatch(a -> a.auth.equals('ROLE_ADMIN')).get()}">
							ADMIN
						</c:when>
						<c:otherwise>
							<input type="checkbox"
								value=""
								data-id="${uvo.id}"
								${uvo.authList.stream().anyMatch(a -> a.auth.equals('ROLE_MANAGER')).get() ? 'checked' : ''}>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</c:forEach>
	</div>
	<script type="text/javascript">
		document.addEventListener('click', e => {
			  const id = e.target.dataset.id;
			  if (id == undefined) return;
	
			  fetch('/user/toggleManager?id=' + id);
			});
	</script>
</div>
<%@ include file="../layout/footer.jsp" %>