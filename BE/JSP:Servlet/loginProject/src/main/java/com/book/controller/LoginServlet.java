package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.LoginDao;
import com.book.dao.LoginDaoImpl;
import com.book.entity.LoginDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		LoginDao dao = LoginDaoImpl.getLoginDao();
		boolean dto  = dao.getLoginUser(userid, userpwd);
		
		if(dto == true) {
			LoginDTO entity = new LoginDTO(userid,userpwd);
			
			HttpSession session = request.getSession();
			session.setAttribute("logOK", entity);
			
			response.sendRedirect("./log/login/loginOK.jsp");
		}else {
			response.sendRedirect("./log/login/fail.jsp");
		}
		
	}

}
