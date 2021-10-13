<%@page import="java.text.DecimalFormat"%>
<%@page import="com.book.entity.BookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %>
<%
	List<BookDTO> list=(List<BookDTO>)request.getAttribute("book");
	
	if(list != null){
%>
		<table border="1" align="center" width="600">
			<tr>
				<td>도서코드</td>
				<td>책이름</td>
				<td>저자</td>
				<td>출판사</td>
				<td>가격</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
<%
			DecimalFormat df=new DecimalFormat("###,###" + "원");
			for(BookDTO dto: list)
			{
%>
			<tr>
				<td><%=dto.getIsbn()%></td>
				<td><%=dto.getTitle()%></td>
				<td><%=dto.getAuthor()%></td>
				<td><%=dto.getCompany()%></td>
				<td><%=df.format(dto.getPrice())%></td>
				<td>
					<form action="/bkshop/book/bookUpdate.jsp" method="post">
						<input type="hidden" name="isbn" value="<%=dto.getIsbn()%>">
						<input type="hidden" name="title" value="<%=dto.getTitle()%>">
						<input type="hidden" name="author" value="<%=dto.getAuthor()%>">
						<input type="hidden" name="company" value="<%=dto.getCompany()%>">
						<input type="hidden" name="price" value="<%=dto.getPrice()%>">
						<input type="submit" value="수정">						         
					</form>
				</td>
				<td>
					<form action="/bkshop/deleteBook" method="post">
						<input type="hidden" name="isbn" value="<%=dto.getIsbn()%>">
						<input type="submit" value="삭제" onclick="return confirm('삭제할까요?')">	
					</form>
				</td>
			</tr>		
<%
			} //end for
%>
		</table>
<%
	} //end if
%>
</body>
</html>