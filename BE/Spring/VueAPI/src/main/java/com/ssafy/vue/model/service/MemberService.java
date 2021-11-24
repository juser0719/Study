package com.ssafy.vue.model.service;

import com.ssafy.vue.model.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;
	public void registerMember(MemberDto memberDto) throws Exception;
	public void updateMember(MemberDto memberDto) throws Exception;
	public void deleteMember(String userid) throws Exception;
	String idCheck(String checkId) throws Exception;
}
