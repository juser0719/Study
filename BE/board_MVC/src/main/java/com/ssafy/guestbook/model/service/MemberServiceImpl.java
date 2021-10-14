package com.ssafy.guestbook.model.service;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.dao.MemberDao;
import com.ssafy.guestbook.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;
	
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	
	public static MemberService getMemberService() {
		return memberService;
	}
	@Override
	public int idCheck(String id) {
		
		return 0;
	}

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
		
		memberDao.registerMember(memberDto);

	}

	@Override
	public MemberDto login(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

}
