<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SSAFY</title>
</head>
<body>
	<div align="center">
		<h3>SSAFY 방명록!!!(session_cookie)</h3>
		<a href="<%= root %>/user/join.jsp">회원가입</a><br> 
		<a href="<%= root %>/user/login.jsp">로그인</a><br> 
		<a href="<%= root %>/guestbook/write.jsp">글쓰기</a><br> 
		<a href="<%= root %>/guestbook?act=list">글목록</a>
	</div>
</body>
</html>