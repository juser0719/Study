<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration ob=session.getAttributeNames();
	while(ob.hasMoreElements()){
		String name=(String)ob.nextElement();             // logId1, logId2
		String value=(String)session.getAttribute(name);  //apple, orange
		
		out.print("session name: " + name +"<br>");
		out.print("session value: " + value +"<br>");
		out.print("session id: " + session.getId() +"<br><br>");
		
		if(name.equals("logId1")){
			session.removeAttribute("logId1");    //logId1제거
		}
	}
	//session.invalidate();   //모든 세션 종료	
%>
<a href="viewSession2.jsp">다음 페이지로 이동</a>
</body>
</html>









