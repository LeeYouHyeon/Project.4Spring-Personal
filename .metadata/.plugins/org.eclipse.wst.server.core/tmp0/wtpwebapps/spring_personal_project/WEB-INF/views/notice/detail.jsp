<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="my-5">
	<div class="container-md mt-3 mb-3 mx-auto border rounded">
		<div class="row py-3 justify-content-center">
			<div class="col-9 d-flex align-items-center">
				<h3 class="m-0 ps-1">${nvo.title}</h3>
			</div>
			<div class="col-2">
				<div class="row justify-content-end">작성일 : ${nvo.regDate}</div>
				<c:if test="${nvo.expDate ne null}">
				<div class="row justify-content-end">
					상단 표시 기한 : ${nvo.expDate.substring(0, 10)}
				</div>
				</c:if>
				<div class="row justify-content-end">조회수 : ${nvo.readCount}</div>
			</div>
		</div>
		<div class="row p-3 border-top">
			<div class="col ps-5 py-3 ms-2">${nvo.content}</div>
		</div>
		<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="pri" />
		<c:if test="${pri.uvo.authList.stream().anyMatch(a -> a.auth.equals('ROLE_MANAGER')).get()}">
			<div class="row mb-2">
				<div class="col-10"></div>
				<div class="col-2 d-flex justify-content-end">
					<div class="w-75 d-flex justify-content-end bg-light border rounded">
						<div class="w-50 d-flex justify-content-center border-end">
							<a href="/notice/modify?nno=${nvo.nno}">
								<button type="button" class="btn btn-light">수정</button>
							</a>
						</div>
						<div class="w-50 d-flex justify-content-center">
							<button type="button" class="btn btn-light">삭제</button>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		</sec:authorize>
	</div>
	<div class="container-md mb-3 mx-auto border rounded">
		<div class="row py-2 border-bottom" id="nextArea">
			<c:choose>
				<c:when test="${next eq null}">
					<div class="col text-center">다음 글이 없습니다.</div>
				</c:when>
				<c:otherwise>
					<div class="col-1 text-center">다음글</div>
					<div class="col-1"></div>
					<div class="col-8">
						<a href="/notice/detail?nno=${next.nno}">${next.title}</a>
					</div>
					<div class="col-2 text-center">${next.regDate}</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row py-2" id="beforeArea">
			<c:choose>
				<c:when test="${before eq null}">
					<div class="col text-center">이전 글이 없습니다.</div>
				</c:when>
				<c:otherwise>
					<div class="col-1 text-center">이전글</div>
					<div class="col-1"></div>
					<div class="col-8">
						<a href="/notice/detail?nno=${before.nno}">${before.title}</a>
					</div>
					<div class="col-2 text-center">${before.regDate}</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp" %>