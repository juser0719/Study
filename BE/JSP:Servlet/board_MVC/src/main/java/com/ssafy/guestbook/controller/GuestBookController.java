package com.ssafy.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.GuestBookServiceImpl;
import com.ssafy.guestbook.model.service.GuestBookService;

@WebServlet("/guestbook")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private GuestBookService guestBookService;
	
	public void init() {
		guestBookService = GuestBookServiceImpl.getGuestBookService();
	}
	
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
		
		if("list".equals(act)) {
			path = listArticle(request,response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if("mvregister".equals(act)) {
			// register 페이지로 이동.
			path = "/guestbook/write.jsp";
			response.sendRedirect(root + path);
		} else if("register".equals(act)) {
			// 등록 버튼 
			path = registerArticle(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if("delete".equals(act)) {
			// 삭제 버튼
			path = deleteArticle(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if("mvmodify".equals(act)) {
			// 수정 페이지로 이동.
			path = mvmodifyArticle(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if("modify".equals(act)) {
			// 수정 버튼 
			path = modifyArticle(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
		
	}
	
	private String modifyArticle(HttpServletRequest request, HttpServletResponse response) {
		GuestBookDto guestBookDto = new GuestBookDto();
		guestBookDto.setArticleNo(Integer.parseInt(request.getParameter("articleno")));
		guestBookDto.setSubject(request.getParameter("subject"));
		guestBookDto.setContent(request.getParameter("content"));
		
		try {
			guestBookService.updateArticle(guestBookDto);
			return "/guestbook?act=list";
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글작성중 문제가 발생했습니다.");
		}
		return "/error/error.jsp";
	}

	private String mvmodifyArticle(HttpServletRequest request, HttpServletResponse response) {
		
		int articleNo=Integer.parseInt(request.getParameter("articleno"));
		GuestBookDto guestBookDto;
		
		try {
			guestBookDto = guestBookService.getArticle(articleNo);
			request.setAttribute("article", guestBookDto);
			return "/guestbook/modify.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","글수정 중 문제 발생!!!");
		}
		return "/error/error.jsp";
	}



	private String deleteArticle(HttpServletRequest request, HttpServletResponse response) {
		// 게시물삭제하기.
		
		int articleNo = Integer.parseInt(request.getParameter("articleno"));
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		
		if(memberDto != null) {
			try {
				guestBookService.deleteArticle(articleNo);
				return "/guestbook?act=list";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글삭제 중 문제 발생!!!");
				return "/error/error.jsp";
			}
		} else
			return "/user/login.jsp";
	}

	private String registerArticle(HttpServletRequest request, HttpServletResponse response) {
		// 게시물 등록하기.
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		// 사용자 정보가져옴.
		
		if(memberDto != null) {
			// 게스트북 게시물 작성자,제목,내용 입력.
			GuestBookDto guestBookDto = new GuestBookDto();
			guestBookDto.setUserId(memberDto.getUserId());
			guestBookDto.setSubject(request.getParameter("subject"));
			guestBookDto.setContent(request.getParameter("content"));
			
			try {
				guestBookService.registerArticle(guestBookDto);
				//Dao 작동으로 DB 로직 처리.
				return "/guestbook?act=list";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 문제 발생!!!");
				return "/error/error.jsp";
			}
			
		} else
			// 만약 로그인 안했다면,
			return "/user/login.jsp";
	}

	private String listArticle(HttpServletRequest request, HttpServletResponse response) {
		// 모든 게시물 가져오기.
		String key = request.getParameter("key");
		String word= request.getParameter("word");
		
		try {
			//로그인할때 설정한 userinfo 가져옴.
			HttpSession session = request.getSession();
			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
			
			if(memberDto != null) {
				// 유저 잘 가져왔다면,
				List<GuestBookDto> list = guestBookService.listArticle(key, word);
				request.setAttribute("articles", list);
				
				return "/guestbook/list.jsp";
			} else
				return "/user/login.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글목록 출력 중 문제 발생!!!");
			return "/error/error.jsp";
		}
	}

}
