package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class e_insertPrepared {
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
			//2. 명령 수행 : 사원번호, 이름, 봉급을 매개변수를 이용해서 코드를 구현하자
			
			
			//2-1. insert
			conn.setAutoCommit(false);
			int empno = 1;
			String ename = "홍길동";
			double sal = 5500;
			
			String sql_insert = "insert into emp(empno, ename, sal) values (?,?,?)";
			pstmt = conn.prepareStatement(sql_insert);
			
			// sql_insert 매개변수에 값 전달 및 변경 코드
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setDouble(3, sal);
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				conn.commit();
			}else {
				System.out.println("쿼리 이상함");
				conn.rollback();
			}
			
			//2-2. select
			String sql = "select * from emp";
			rs = pstmt.executeQuery(sql);
			
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
