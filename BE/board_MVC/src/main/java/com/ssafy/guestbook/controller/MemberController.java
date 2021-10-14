package com.ssafy.guestbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.MemberService;
import com.ssafy.guestbook.model.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = MemberServiceImpl.getMemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		String path= "/index.jsp";
		
		if("mvregister".equals(act)) {
			path = "/user/join.jsp";
			response.sendRedirect(path);
			
		} else if("mvlogin".equals(act)) {
			path = "/user/login.jsp";
			response.sendRedirect(path);
			
		} else if("idcheck".equals(act)) {
			path = idCheck(request,response);
			
		}else if("register".equals(act)) {
			path = registerMember(request,response);
			
		} else if("".equals(act)) {
			
		}
	}

	private String idCheck(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("ckid");
		int cnt  = 1;
		try {
			cnt = memberService.idCheck(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/user/idchck_result.jsp";
	}

	private String registerMember(HttpServletRequest request, HttpServletResponse response) {
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(request.getParameter("userid"));
		memberDto.setUserName(request.getParameter("username"));
		memberDto.setUserPwd(request.getParameter("userpwd"));
		memberDto.setEmail(request.getParameter("emailid")+"@"+ request.getParameter("emaildomain"));
		
		try {
			memberService.registerMember(memberDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "문제발생!!!");
			return "/error/error.jsp";
		}
		return "/user/login.jsp";
	}

}
