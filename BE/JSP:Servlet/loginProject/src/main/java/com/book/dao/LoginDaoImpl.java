package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.entity.LoginDTO;
import static common.JdbcTemplate.*;
public class LoginDaoImpl implements LoginDao {

	private static LoginDaoImpl loginDao;
	
	public static LoginDao getLoginDao() {
		if(loginDao == null)
			loginDao = new LoginDaoImpl();
		
		return loginDao;
	}
	
	@Override
	public boolean getLoginUser(String userid, String userpwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res =null;
		LoginDTO dto = null;
		
		try {
			conn = getConnection();
			String sql = "select * from member where userid=? and userpwd=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, userpwd);
			res = ps.executeQuery();
			
			if(res.next()) {
				dto = new LoginDTO();
				dto.setUserid(res.getString("userid"));
				dto.setUserpwd(res.getString("userpwd"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(res);
			close(ps);
			close(conn);
		}
		return false;
	}

}
