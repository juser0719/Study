package com.ssafy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.guestbook.model.MemberDto;

@SuppressWarnings("deprecation")
public class ConfirmInterceptor extends HandlerInterceptorAdapter {
	// 컨트롤러가기전에 실행할 함수.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 1. 세션 가져와
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		// 2 멤버정보 가져와 .
		if(memberDto == null) {
			// 2-1. 만약 멤버 정보 없다면 로그인 안한거임.
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		// 2-2. 안걸렸으면 로그인 한 사람임.
		return true;
	}
	
}
