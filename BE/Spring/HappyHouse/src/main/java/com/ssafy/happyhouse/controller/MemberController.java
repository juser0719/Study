package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.MemberService;

//회원 처리용 controller
@Controller
@RequestMapping("/user")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session,
			HttpServletResponse response) throws Exception {
		System.out.println(map.get("userId") + " " + map.get("userPwd"));
		System.out.println("!!!!");
		MemberDto memberDto = memberService.login(map);
		if (memberDto != null) {
			session.setAttribute("userinfo", memberDto);

			Cookie cookie = new Cookie("ssafy_id", map.get("userId"));
			cookie.setPath("/");
			if ("saveok".equals(map.get("idsave"))) {
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
			} else {
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			System.out.println("@@@@@@");
			return "redirect:/";
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			System.out.println("Dto null");
			return "user/login";
		}
	}

	@GetMapping("/register")
	public String mvRegister() throws Exception {
		return "/signup";
	}

	@PostMapping("/register")
	public String register(MemberDto userDto, Model model) throws Exception {
		memberService.registerMember(userDto);
		return "/index";
	}
	
	@GetMapping("/info")
	public String mvInfo() {
		System.out.println("@@@@");
		return "/userInfo";
	}

	@PutMapping("/info")
	public String userModify(@RequestBody MemberDto memberDto) throws Exception {
		memberService.updateMember(memberDto);
		return "/userInfo";
	}
	
	@DeleteMapping(value = "/info/{userid}")
	public String userDelete(@PathVariable("userid") String userid) throws Exception {
		memberService.deleteMember(userid);
		return "/index";
	}
}
