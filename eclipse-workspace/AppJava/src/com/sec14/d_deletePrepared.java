package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class d_deletePrepared {
	public static void main(String[] args) {
		//1. 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/my_emp?";
			String user = "mydb";
			String password = "zshfz8076";
			
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" + "user=mydb&password=zshfz8076");
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) {
				System.out.println("연결중");
			}
			//2. 명령 수행
			conn.setAutoCommit(false);
			String sql_delete = "delete from emp where ename = ?";
		
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setString(1, "홍길동");
			
			
			int res = pstmt.executeUpdate();
			
			if(res>0) {
				conn.commit();
			}else {
				System.out.println("쿼리 이상함");
				conn.rollback();
			}
			
			//2-2. select
			String sql = "select * from emp";
			rs = pstmt.executeQuery(sql); //부모 메서드는 자식이 가져다 쓸 수 있음
			
			//3. 결과 출력
			while(rs.next()) {
				System.out.println(rs.getString("empno") + "\t" + rs.getString(2)+ "\t" + rs.getDouble(6) );
			}
			
		}catch(SQLException ex) {
			System.out.println("SQLExeption: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}finally {
			try {
				rs.close(); //반대로 닫아줘야 함
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
