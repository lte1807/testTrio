<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div  class="container">
	<form>
	<div class="form-group">
		<label for="username">Username</label>
		<input type="text" class="form-control" placeholder="Enter Username" id="username">
	</div>
		<div>
			<label for="email">Email</label>
			<input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
		<div>
			<label for="pwd">password</label>
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">회원가입</button>
</div>
<script src="/js/user.js"></script>
<br/>
<%@ include file="../layout/footer.jsp" %>	
