package com.sec15;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

import static common.JDBCTemplate.*; //자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출

public class b_proc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 사원번호 입력하세요: ");
		int empno = sc.nextInt();
		
		//연결 확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			String sql = "{call my_emp.PRO02_DELETE(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empno); //바인딩
			cstmt.executeUpdate(); //프로시저 실행
			System.out.println("삭제 완료");
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
