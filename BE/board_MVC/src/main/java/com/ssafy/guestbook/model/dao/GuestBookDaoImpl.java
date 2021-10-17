package com.ssafy.guestbook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.util.DBUtil;

public class GuestBookDaoImpl implements GuestBookDao {
	
	private static GuestBookDao guestBookDao = new GuestBookDaoImpl();
	
	private DBUtil dbUtil;
	
	private GuestBookDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static GuestBookDao getGuestBookDao() {
		return guestBookDao;
	}

	@Override
	public void registerArticle(GuestBookDto guestBookDto) throws Exception {
		// DB에 게시글 등록하기.
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder registerArticle = new StringBuilder();
			registerArticle.append("insert into guestbook (userid, subject, content, regtime) \n");
			registerArticle.append("values (?, ?, ?, now())");
			pstmt = conn.prepareStatement(registerArticle.toString());
			pstmt.setString(1, guestBookDto.getUserId());
			pstmt.setString(2, guestBookDto.getSubject());
			pstmt.setString(3, guestBookDto.getContent());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) {
		
		List<GuestBookDto> list = new ArrayList<GuestBookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder listArticle = new StringBuilder();
			listArticle.append("select g.articleno, g.userid, g.subject, g.content, g.regtime, m.username \n");
			listArticle.append("from guestbook g, ssafy_member m \n");
			listArticle.append("where g.userid = m.userid \n");
			
			if(!word.isEmpty()) //검색어가 있다면,
			{
				if(key.equals("userid")) // userid로 검색했다면,
					listArticle.append("and g.userid = ? \n");
				else if(key.equals("subject")) // subject 로 검색했다면,
					listArticle.append("and g.subject like ? \n");
			}
			
			listArticle.append("order by g.articleno desc \n");
			pstmt = conn.prepareStatement(listArticle.toString());
			
			if(key.equals("userid"))
				pstmt.setString(1, word);
			else if(key.equals("subject"))
				pstmt.setString(1, "%" + word + "%"); // sql %word% 모양 만들어주려구. 
			rs = pstmt.executeQuery();
			
			while (rs.next()) 
			{
				GuestBookDto guestBookDto = new GuestBookDto();
				guestBookDto.setArticleNo(rs.getInt("articleno"));
				guestBookDto.setUserId(rs.getString("userid"));
				guestBookDto.setUserName(rs.getString("username"));
				guestBookDto.setSubject(rs.getString("subject"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegTime(rs.getString("regtime"));
				
				list.add(guestBookDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public GuestBookDto getArticle(int articleNo) throws Exception {
		// DB에서 articleNo 게시물 가져오기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		GuestBookDto guestBookDto=null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder registerArticle = new StringBuilder();
			registerArticle.append("select articleno, userid, subject,content,regtime \n ");
			registerArticle.append("from guestbook \n");
			registerArticle.append("where articleno=?");
			pstmt = conn.prepareStatement(registerArticle.toString());
			pstmt.setInt(1, articleNo);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				guestBookDto=new GuestBookDto();
				guestBookDto.setArticleNo(rs.getInt("articleno"));
				guestBookDto.setUserId(rs.getString("userid"));
				guestBookDto.setSubject(rs.getString("subject"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegTime(rs.getString("regtime"));
			}
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return guestBookDto;
	}

	@Override
	public void updateArticle(GuestBookDto guestBookDto) throws Exception {
		// 게시물 업데이트하기.
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder registerArticle = new StringBuilder();
			registerArticle.append("update guestbook set subject=?, content=? ");
			registerArticle.append(" where articleno=?");
			pstmt = conn.prepareStatement(registerArticle.toString());
			pstmt.setString(1, guestBookDto.getSubject());
			pstmt.setString(2, guestBookDto.getContent());
			pstmt.setInt(3, guestBookDto.getArticleNo());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}

	}

	@Override
	public void deleteArticle(int articleNo) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder registerArticle = new StringBuilder();
			registerArticle.append("delete from guestbook \n");
			registerArticle.append("where articleno = ?");
			pstmt = conn.prepareStatement(registerArticle.toString());
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}

	}

}
