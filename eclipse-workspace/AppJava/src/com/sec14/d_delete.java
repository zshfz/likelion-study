package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class d_delete {
	public static void main(String[] args) {
		//1. 연결
		Connection conn = null;
		Statement stmt = null;
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
			stmt = conn.createStatement();
			
			//2-1. delete
			conn.setAutoCommit(false);
			String delete_name = "홍길동";
			String sql_insert = "delete from emp where ename = '" + delete_name +  "'";
			int res = stmt.executeUpdate(sql_insert);
			if(res>0) {
				conn.commit();
			}else {
				System.out.println("쿼리 이상함");
				conn.rollback();
			}
			
			//2-2. select
			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
