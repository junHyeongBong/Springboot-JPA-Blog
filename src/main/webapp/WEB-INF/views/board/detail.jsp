<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../layout/header.jsp" %>

<div class="container">
	
	<button id="historyBack" class="btn btn-secondary">돌아가기</button>
	<c:if test="${board.user.id == principal.user.id}">
		<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br /><br />
	<div>
		<input type="hidden" value="${board.id}" name="boardId">
		글 번호 : <span>${board.id} </span>
		작성자 : <span><i>${board.user.username} </i></span>
	</div>
	<br />
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>
	  <div>${board.content}</div>
	</div>
	<hr />
</div>
<script src="${pageContext.request.contextPath}/js/board.js" ></script>
<%@include file="../layout/footer.jsp" %>