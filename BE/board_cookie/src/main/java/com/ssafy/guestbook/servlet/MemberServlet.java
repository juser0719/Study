package com.ssafy.guestbook.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.guestbook.dto.MemberDto;
import com.ssafy.util.DBUtil;


@WebServlet("/user")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBUtil dbUtil = DBUtil.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
	// 회원 정보 CRUD 해야함.
		String root= request.getContextPath();
		String act = request.getParameter("act");
		String path= "/index.jsp";
		
		if("register".equals(act)) {
			path = registerMember(request,response);
			response.sendRedirect(root+path);
		} else if("".equals(act)) {
			
		} else {
			response.sendRedirect(root+path);
		}
	}

	private String registerMember(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("userid");
		String name = request.getParameter("username");
		String pass = request.getParameter("userpwd");
		String email = request.getParameter("emailid") + "@" + request.getParameter("emaildomain");

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			String sql = "insert into ssafy_member (userid,username,userpwd,email,joindate) \n";
			sql += "value (?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pass);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
//			회원가입 실패 혹은 에러 문제.
		}
		
		return "/user/login.jsp";
	}

	private String loginMember(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpwd");
		
		MemberDto memberDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "select userid, username, email \n";
			sql += "from ssafy_member \n";
			sql += "where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(id);
				memberDto.setUserName(rs.getString("username"));
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
//		request.setAttribute("userinfo", memberDto);
		if(memberDto != null) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);
		}
		
		return "/index.jsp";
	}
}
