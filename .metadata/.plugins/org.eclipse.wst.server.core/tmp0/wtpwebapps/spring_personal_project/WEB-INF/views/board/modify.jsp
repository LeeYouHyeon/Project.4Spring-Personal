<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<sec:authentication property="principal" var="pri"/>
<div class="my-5 p-0">
	<c:set value="${bvo.bno}" var="bno" />
	<c:set value="${pri.uvo.name}" var="name" />
	<div class="container-md w-50 my-3 p-4 bg-body-tertiary">
		<input type="text"
			id="title"
			name="title"
			class="form-control mb-3 py-2"
			placeholder="제목을 입력해주세요."
			value="${bvo.title}">
		<textarea rows="10" cols="30"
			id="content"
			name="content"
			class="form-control mb-3 py-2"
			placeholder="내용을 입력해주세요.">${bvo.content}</textarea>
		<div class="d-flex justify-content-end mb-3">
			<button type="button" id="button" class="btn btn-warning">수정</button>
		</div>
	</div>
	<script type="text/javascript">
		const nick = `<c:out value="${name}" />`;
		const bno = `<c:out value="${bno}" />`;
	</script>
	<script type="text/javascript" src="/resources/js/boardModify.js"></script>
</div>
<%@ include file="../layout/footer.jsp" %>