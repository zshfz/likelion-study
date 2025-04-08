package com.sec15;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;

import static common.JDBCTemplate.*; //자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출

public class e_proc {

	public static void main(String[] args) {
		//연결 확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			int empno = 7934;
			
			String sql = "{call PRO09_SALARY_BONUS(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empno); //IN
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER); //OUT
			cstmt.execute(); //실행
			
			//OUR 부분 리턴값 출력
			int res = cstmt.getInt(1);
			System.out.println("사원번호: " + empno + "의 예상 보너스는 " + res);
			
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
