<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../views/layout/header.jsp" %>
<div class="container-md my-3 d-flex justify-content-evenly">
	<div class="w-50 border rounded p-3 me-3" id="introduce">
		Spring을 통해 만든 게시판 예제입니다.
	</div>
	<div class="w-50" id="hots">
		<h3 class="text-center mb-3 p-3">최근 인기글</h3>
	</div>
	<script type="text/javascript">
	const hots = document.getElementById('hots');
	
	/* innerHTML이 작동하지 않아 createElement로 작성 */
	fetch('/board/hots')
		.then(resp => resp.json())
		.then(json => {
			json.forEach(({bno, title, name, content, regDate, cmtCount}) => {
				console.log(bno, title, name, content, regDate, cmtCount);
				const hot = document.createElement('a');
				hot.href = '/board/detail?bno=' + bno;
				
				const container =  document.createElement('div');
				['mb-3', 'border', 'rounded', 'p-3'].map(e => container.classList.add(e));
				
				const box = ['h4', 'div', 'div', 'div'].map(e => document.createElement(e));
				box[0].innerText = title;
				box[1].innerText = name;
				box[2].innerText = content;
				box[3].innerText = name + " " + regDate.substring(0, 10) + " " + cmtCount;
				
				box.map(e => {
					console.log(e);
					container.appendChild(e);
				});
				hot.appendChild(container);
				console.log(hot);
				hots.appendChild(hot);
			})
		}).catch(console.log)
	</script>
</div>
<%@ include file="../views/layout/footer.jsp" %>