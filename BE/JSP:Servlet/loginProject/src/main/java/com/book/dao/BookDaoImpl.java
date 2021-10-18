package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.book.entity.BookDTO;
import static common.JdbcTemplate.*;

public class BookDaoImpl implements BookDao{

	public static BookDaoImpl bookDao;
	
	public static BookDao getBookDao() {
		if(bookDao == null) {
			bookDao = new BookDaoImpl();
		}
		return bookDao;
	}
	// 추가하기---------------------------------------------------------------------
	@Override
	public int insertBook(BookDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int n=0;
		
		try {
			conn=getConnection();
			conn.setAutoCommit(false);
			
			String sql="insert into bookshop(isbn,title,author,company,price) values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIsbn());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getAuthor());
			pstmt.setString(4, dto.getCompany());
			pstmt.setInt(5, dto.getPrice());
			n=pstmt.executeUpdate();
			
			if(n>0)
				commit(conn);    // import static common.JdbcTemplate.*; 가 있어서 에러 안남
			
		}catch(SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
			close(conn);
		}
		return n;
	}
	// 전체보기---------------------------------------------------------------------
	@Override
	public List<BookDTO> listBook() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BookDTO> list=new ArrayList<>();
		BookDTO dto=null;
		
		try {
			conn=getConnection();
			String sql="select * from bookshop";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				dto=new BookDTO();
				dto.setIsbn(rs.getString("isbn"));    // mysql의 bookshop테이블의 컬럼명:isbn, title.... 
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setCompany(rs.getString("company"));
				dto.setPrice(rs.getInt("price"));
				
				list.add(dto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return list;
	}
	// 수정하기---------------------------------------------------------------------
	@Override
	public int updateBook(BookDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int n=0;
		
		try {
			conn=getConnection();
			conn.setAutoCommit(false);
			
			String sql="update bookshop set title=?, author=?, company=?, price=? where isbn=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getCompany());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setString(5, dto.getIsbn());
			n=pstmt.executeUpdate();
			
			if(n>0)
				commit(conn);    
			
		}catch(SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
			close(conn);
		}
		return n;
	}
	// 삭제하기---------------------------------------------------------------------
	@Override
	public int deleteBook(BookDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int n=0;
		
		try {
			conn=getConnection();
			conn.setAutoCommit(false);
			
			String sql="delete from bookshop where isbn=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIsbn());
			n=pstmt.executeUpdate();
			
			if(n>0)
				commit(conn);    
			
		}catch(SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
			close(conn);
		}
		return n;
	}
}
