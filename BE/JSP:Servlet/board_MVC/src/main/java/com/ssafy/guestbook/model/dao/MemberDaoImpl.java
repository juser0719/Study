package com.ssafy.guestbook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao = new MemberDaoImpl();
	private DBUtil dbUtil;
	
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}
/////싱글톤 설정.
	
	@Override
	public int idCheck(String id) throws SQLException {
		//해당 아이디가 DB에 있는지 판별.
		int cnt =1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("select count(userid)\n");
			loginMember.append("from ssafy_member\n");
			loginMember.append("where userid=?");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return cnt;
	}

	@Override
	public void registerMember(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			String sql = "insert into ssafy_member (userid,username,userpwd,email,joindate) \n";
			sql += "value (?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPwd());
			pstmt.setString(4, memberDto.getEmail());
			
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt,conn);
		}
	}

	@Override
	public MemberDto login(String id, String pass) throws Exception {
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
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

	

}
