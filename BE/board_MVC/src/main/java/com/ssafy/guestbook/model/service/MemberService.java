package com.ssafy.guestbook.model.service;

import com.ssafy.guestbook.model.MemberDto;

public interface MemberService {
	int idCheck(String id) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	// 왜냐면 안되면 에러페이지 넘어가기 위
	MemberDto login(String id,String pass) throws Exception;
	
//	MemberDto getMember(String id);
//	// 수정하기 위해 해당 정보 가져옴.
//	void updateMember(MemberDto memberDto);
//	// 수정된 멤버 정보 가져가서수정함.
//	void deleteMember(String id);
}
