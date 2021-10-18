<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>SSAFY 방명록!!(Bean)</h3>
		<a href="${root}/guestbook/write.jsp">글쓰기</a><br>
		<a href="${root}/guestbook?act=list">글목록</a>
	</div>
</body>
</html>