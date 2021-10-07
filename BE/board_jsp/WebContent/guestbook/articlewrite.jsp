<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,com.ssafy.util.DBUtil"%>
<%!
private DBUtil dbUtil = DBUtil.getInstance();
%>
<%
request.setCharacterEncoding("utf-8");
String userid = request.getParameter("userid");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

Connection conn = null;
PreparedStatement pstmt = null;
int cnt = 0;
try {
	conn = dbUtil.getConnection();
	StringBuilder registerArticle = new StringBuilder();
	registerArticle.append("insert into guestbook (userid, subject, content, regtime) \n");
	registerArticle.append("values (?, ?, ?, now())");
	pstmt = conn.prepareStatement(registerArticle.toString());
	pstmt.setString(1, userid);
	pstmt.setString(2, subject);
	pstmt.setString(3, content);
	cnt = pstmt.executeUpdate();
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	dbUtil.close(pstmt, conn);
}

if(cnt != 0) {
	response.sendRedirect(request.getContextPath() + "/guestbook/writesuccess.jsp");
} else {
	response.sendRedirect(request.getContextPath() + "/guestbook/writefail.jsp");
}
%>
