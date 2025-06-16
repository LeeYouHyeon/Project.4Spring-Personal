<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../views/layout/header.jsp" %>
<div class="container-md my-3 d-flex justify-content-evenly">
	<div class="w-50 border rounded p-3 me-3" id="introduce">
		Spring을 통해 만든 게시판 예제입니다.
	</div>
	<div class="w-50" id="hots">
		<h3 class="text-center mb-3 p-3" style="
			text-overFlow: ellipsis;
			overflow: hidden;
			white-space:no-wrap;
		">최근 인기글</h3>
	</div>
	<script type="text/javascript">
	fetch('/board/hots').then(resp => resp.json())
	.then(json => {
	  json.forEach(json => {
	    const {bno, title, name, content, regDate, cmtCount} = json;
	    console.log(bno, title, name, content, regDate, cmtCount);
	    
	    document.getElementById('hots').innerHTML += `
	      <a href="/board/detail?bno=${bno}">
	        <div class="mb-3 border rounded">
	          <h4>${title}</h4>
	          <div>${name}</div>
	          <div>${content}</div>
	          <div>${name} | ${regDate.substring(0, 10)} | ${cmtCount}</div>
	    </div></a>`;
	  });
	}).catch(console.log);
	</script>
</div>
<%@ include file="../views/layout/footer.jsp" %>