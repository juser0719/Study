<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 상품을 등록해 해주세요.</h3>
<!-- http://localhost:8080/1007login/main -->
<form action="main" method="post">
	<input type="hidden" name="action" value="reigster">
	<div>
	상품명 : <input type="text" id="productName" name="productName" value="SmartTV"><br>
	</div>
	<div>
	상품 가격 : <input type="number" id="productPrice" name="productPrice" value="50000"><br>
	</div>
	<div>
	상품 설명 : <input type="text" id="ProductDescrip" name="ProductDescrip" value="So Smart !"><br>
	</div>
	<input type="submit" value="저장">
	<input type="reset" value="취소">
</form>
</body>
</html>