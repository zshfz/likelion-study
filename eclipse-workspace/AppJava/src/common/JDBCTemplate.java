package common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	//DB Connection Case 1 깂 대입
//	public static Connection getConnection() {
//
//		Connection conn = null;
//
//		try {
//			String url = "jdbc:mysql://localhost:3306/my_emp?";
//			String user = "mydb";
//			String password = "zshfz8076";
//
//			conn = DriverManager.getConnection(url, user, password);
//			conn.setAutoCommit(false); //트랜잭션 수동 설정
//			
//			if (!conn.isClosed()) {
//				System.out.println("연결중");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return conn;
//	}
	
	//DB Connection Case 2 properties 파일 로드
	public static Connection getConnection() {

		Connection conn = null;
		Properties prop = new Properties();

		try (InputStream input = JDBCTemplate.class.getClassLoader().getResourceAsStream("db.properties")){
			if(input == null) {
				throw new RuntimeException("db.properties 파일 없음");
			}
			
			prop.load(input);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");

			Class.forName(driver); //JDK버전 상관없이 리소스 로드 할 때는 반드시 명시
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); //트랜잭션 수동 설정
			
			if (!conn.isClosed()) {
				System.out.println("연결중");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
	//DB Close
	public static void Close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("명령 오류: " + e.getSQLState() + "\t" + e.getMessage());
			}
		}
	}
	
	//statemenet close
	public static void Close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("명령 오류: " + e.getSQLState() + "\t" + e.getMessage());
			}
		}
	}
	
	//resultset close
	public static void Close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("쿼리 리턴 오류: " + e.getSQLState() + "\t" + e.getMessage());
			}
		}
	}
	
	//트랜잭션 처리
	//commit
	public static void commit(Connection conn) {
		if(conn != null) {
			try {
				conn.commit();
			} catch (SQLException e) {
				System.out.println("명령 오류: " + e.getSQLState() + "\t" + e.getMessage());
			}
		}
	}
	
	//rollback
	public static void rollback(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				System.out.println("명령 오류: " + e.getSQLState() + "\t" + e.getMessage());
			}
		}
	}
}
