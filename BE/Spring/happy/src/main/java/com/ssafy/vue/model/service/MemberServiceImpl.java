package com.ssafy.vue.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired

	private SqlSession sqlSession;

	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if (memberDto.getUserid() == null || memberDto.getUserpwd() == null)
			return null;
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).userInfo(userid);
	}

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
//		validation check
		sqlSession.getMapper(MemberMapper.class).registerMember(memberDto);
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).updateMember(memberDto);
	}
	
	@Override
	public void deleteMember(String userid) throws Exception {
		sqlSession.getMapper(MemberMapper.class).deleteMember(userid);
	}
	@Override
	public String idCheck(String checkId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).idCheck(checkId); // 0 or 1
	}

}
