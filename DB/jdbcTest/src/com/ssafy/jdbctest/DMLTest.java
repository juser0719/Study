package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * JDBC 작업 순서
 * 1. Driver Loading
 * 2. DB 연결 (Connection 생성)
 * 3. SQL 실행 준비
 *   3-1. SQL 작성.
 *   3-2. Statement 생성 (Statement, PreparedStatement)
 * 4. SQL 실행
 *   4-1. I, U, D
 *      int x = stmt.execteUpdate(sql);
 *   	int x = pstmt.executeUpdate();
 *   4-2. S
 *      ResultSet rs = pstmt.executeQuery();
 *      rs.next() [단독, if, while]
 *      값얻기 : rs.getString()
 *            rs.getInt() 등등등....
 * 5. DB 연결 종료 : 연결 역순으로 종료, finally, AutoCloseable, try-with-resource (JDK7이상)
 * 	if(rs != null)
 *    		rs.close()
 *  	if(pstmt != null)
 *  		pstmt.close();
 *  	if(conn != null)
 *  		conn.close();
 */

public class DMLTest {
	public DMLTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버로딩 성공!!");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		DMLTest dmlTest = new DMLTest();
		dmlTest.insertProduct("G123459","GAL50",3980000,"is_good!");
//		dmlTest.updateProduct(20000);
	}

	private void insertProduct(String productId, String productName, int productPrice, String productDesc) {
		PreparedStatement psmt = null;
		Connection conn = null;
		try {
			conn = getConnection();
			String sql = "insert into ssafy_product (product_id, product_name , product_price, product_desc) \n";
			sql += "values (?, ?, ?, ?)";
			// 3-2. Statement 생성 
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, productId); //N 번째 ?에 무슨 값을 넣을거냐?
			psmt.setString(2, productName);
			psmt.setInt(3, productPrice);
			psmt.setString(4, productDesc);
			// I, U, D
			int cnt = psmt.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			close(psmt, conn);

		}
	}

	private void close(PreparedStatement psmt, Connection conn) {
		try {
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","127wjs778!");
		return conn;
	}
}
