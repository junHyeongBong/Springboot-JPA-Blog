<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../layout/header.jsp" %>

<div class="container">
	<form>
		<input type="hidden" value="${principal.user.id}" name="updateUserId">
		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text" name="updateUserName" class="form-control" value="${principal.user.username}" placeholder="Enter username" id="username" readonly>
		</div>
		
		<c:if test="${empty principal.user.oauth}">
			<div class="form-group">
				<label for="pwd">Password</label> 
				<input type="password" class="form-control" placeholder="Enter password" name="userUpdatePassword">
			</div>
		</c:if>
		
		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" class="form-control" value="${principal.user.email}" placeholder="Enter email" name="userUpdateEmail" readonly>
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">회원수정완료</button>
</div>

<script src="${pageContext.request.contextPath}/js/user.js" ></script>
<%@include file="../layout/footer.jsp" %>