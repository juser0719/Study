package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ssafy.jdbctest.util.DBConnection;

// DAO: Data Access Object(데이터 베이스와 연동해서 CRUD처리를 하는 것)
public class APTDaoImpl implements APTDao{
	private static APTDao APTDao;
	
	public static APTDao getAPTDao() {
		if (APTDao == null)
			APTDao = new APTDaoImpl();
		return APTDao;
	}

	@Override
	public APTDto searchAPT(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		APTDto dealDto = new APTDto();
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			 sql.append("select dong, AptName, dealAmount \n");
	         sql.append("from housedeal \n");
	         sql.append("where no = "+ no +";");
	         
	         pstmt = conn.prepareStatement(sql.toString());
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 dealDto.setDong(rs.getString("dong"));
	        	 dealDto.setName(rs.getString("AptName"));
	        	 dealDto.setPrice(rs.getInt("dealAmount"));
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(dealDto.toString());
		return dealDto;
	}

	@Override
	public List<APTDto> searchAPTs() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<APTDto> list = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			 sql.append("select dong, AptName, dealAmount \n");
	         sql.append("from housedeal \n");
	    
	         pstmt = conn.prepareStatement(sql.toString());
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 APTDto dealDto = new APTDto();
	        	 dealDto.setDong(rs.getString("dong"));
	        	 dealDto.setName(rs.getString("AptName"));
	        	 dealDto.setPrice(rs.getInt("dealAmount"));
	             
	             list.add(dealDto);
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<APTDto> favoriteDong(String[] dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<APTDto> list = new ArrayList<>();
		try {
			 conn = DBConnection.getConnection();
			
			for(int i = 0 ; i < dong.length; i++) {
				StringBuilder sql = new StringBuilder();
				 sql.append("select dong, AptName, dealAmount \n");
		         sql.append("from housedeal \n");
		         sql.append("where dong ="+ dong[i]+";");
		    
		         pstmt = conn.prepareStatement(sql.toString());
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {
		        	 APTDto dealDto = new APTDto();
		        	 dealDto.setDong(rs.getString("dong"));
		        	 dealDto.setName(rs.getString("AptName"));
		        	 dealDto.setPrice(rs.getInt("dealAmount"));
		             
		             list.add(dealDto);
		         }
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<String> searchLoc() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> res = new ArrayList<String>();
		try {
			 conn = DBConnection.getConnection();
		     StringBuilder sql = new StringBuilder();
		     sql.append("select sido_name \n");
		     sql.append("from sidocode \n");
		     
	         pstmt = conn.prepareStatement(sql.toString());
	         rs = pstmt.executeQuery();
	         int idx = 1;
	         List<String> si = new ArrayList<String>();
	         while(rs.next()) {
	        	String si_name= rs.getString("sido_name");
	        	si.add(si_name);
	            System.out.printf("%d. %s\n",idx,si_name);
	            idx++;
	         }
	         Scanner sc = new Scanner(System.in);
	         idx = sc.nextInt()-1;
	         
	         
		  
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

}
