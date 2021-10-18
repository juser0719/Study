package com.ssafy.guestbook.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.guestbook.dto.GuestBookDto;

import util.DBUtil;

@WebServlet("/guestbook")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DBUtil dbUtil = DBUtil.getInstance();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String act=request.getParameter("act");
		String path="/index.jsp";
		
		if("register".equals(act)) {
			path=registerArticle(request, response);
		}else if("list".equals(act)) {
			path=listArticle(request, response);
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);  // 권한 위임
	}
	
	private String registerArticle(HttpServletRequest request, HttpServletResponse response) {
		String userid=request.getParameter("userid");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int cnt=0;
		
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("insert into guestbook (userid, subject, content, regtime) \n");
			sql.append("values (?, ?, ?, now())");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			cnt=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt, conn);
		}
		return (cnt != 0)? "/guestbook/writesuccess.jsp":"/guestbook/writefail.jsp";
	}
	
	private String listArticle(HttpServletRequest request, HttpServletResponse response) {
		List<GuestBookDto>  list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select articleno, userid, subject, content, regtime \n");
			sql.append("from guestbook \n");
			sql.append("order by articleno desc \n");
			pstmt=conn.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GuestBookDto dto=new GuestBookDto();
				dto.setArticleNo(rs.getInt("articleno"));
				dto.setUserId(rs.getString("userid"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegTime(rs.getString("regtime"));
				
				list.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt, conn);
		}
		request.setAttribute("articles", list);
		return "/guestbook/list.jsp";
	}
	
}














