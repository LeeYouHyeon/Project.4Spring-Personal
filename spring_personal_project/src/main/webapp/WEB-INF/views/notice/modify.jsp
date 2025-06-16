<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="my-5 p-0">
	<div class="container-md w-50 my-3 p-4 bg-body-tertiary">
		<div class="row mb-3">
			<div class="col-8">
				<input type="text"
					id="title"
					name="title"
					class="form-control"
					placeholder="제목을 입력해주세요."
					value="${nvo.title}"
					required>
			</div>
			<div class="col-2 d-flex align-items-center">
				<div class="w-75 text-center">표시기한</div>
				<div class="w-25 form-check m-0 p-0 d-flex justify-content-center">
					<input class="form-check-input"
						type="checkbox"
						value=""
						id="expDateBtn"
						${nvo.expDate eq null ? '' : 'checked'}>
				</div>
			</div>
			<div class="col-2 d-flex align-items-center">
				<input type="date"
					id="expDate"
					${nvo.expDate eq null ? 'disabled' : nvo.expDate }>
			</div>
		</div>

		<textarea rows="10" cols="30"
			id="content"
			name="content"
			class="form-control mb-3 py-2"
			placeholder="내용을 입력해주세요.">${nvo.content}</textarea>
		<div class="d-flex justify-content-end mb-3">
			<button type="button" id="submitBtn" class="btn btn-primary">수정</button>
		</div>
	</div>
	<script type="text/javascript">
		const nno = `<c:out value="${nvo.nno}" />`;
	</script>
	<script type="text/javascript" src="/resources/js/noticeModify.js"></script>
</div>
<%@ include file="../layout/footer.jsp" %>