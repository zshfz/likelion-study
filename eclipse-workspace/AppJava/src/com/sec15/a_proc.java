package com.sec15;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;

import static common.JDBCTemplate.*; //자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출

public class a_proc {

	public static void main(String[] args) {
		//연결 확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			String sql = "{call my_emp.PRO01_INSERT()}";
			cstmt = conn.prepareCall(sql);
			cstmt.execute();
			commit(conn);
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(cstmt);
			Close(conn);
		}
	}

}
