package common;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class JDBCTemplate {
	private static String url, user, password;

	static {// static 생성자 역할 -> 정적 메모리 확보를 제일 먼저 실행되고 바인드 됨
		try (InputStream is = JDBCTemplate.class.getClassLoader().getResourceAsStream("db.properties")) {
			Properties prop = new Properties();
			prop.load(is);
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close(AutoCloseable ac) {
		try {
			if (ac != null)
				ac.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			if (conn != null)
				conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null)
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}